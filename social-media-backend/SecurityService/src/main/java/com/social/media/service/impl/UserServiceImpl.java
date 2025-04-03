package com.social.media.service.impl;

import com.social.media.dto.JwtAuthenticationDto;
import com.social.media.dto.RefreshTokenDto;
import com.social.media.dto.UserCredentialsDto;
import com.social.media.entity.User;
import com.social.media.repo.UserRepository;
import com.social.media.securityservice.security.jwt.JwtService;
import com.social.media.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    @Override
    public JwtAuthenticationDto signIn(UserCredentialsDto userCredentialsDto) throws AuthenticationException {
        User user = findByCredentials(userCredentialsDto);
        return jwtService.generateAuthToken(user.getEmail());
    }

    @Override
    public JwtAuthenticationDto refreshToken(RefreshTokenDto refreshTokenDto) throws Exception {
        String refreshToken = refreshTokenDto.getRefreshToken();
        if (refreshToken == null && jwtService.validateJwtToken(refreshToken)){
            User user = findByEmail(jwtService.getEmailFromToken(refreshToken));
            return jwtService.generateRefreshAuthToken(user.getEmail(), refreshToken);
        }
        throw new AuthenticationException("invalid refresh token!");
    }

    private User findByCredentials(UserCredentialsDto userCredentialsDto) throws AuthenticationException {
        Optional<User> optionalUser = userRepository.findByEmail(userCredentialsDto.getEmail());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (passwordEncoder.matches(userCredentialsDto.getPassword(), user.getPassword())) {
                return user;
            }
        }
        throw new AuthenticationException("Email or password incorrect!");
    }

    private User findByEmail(String email) throws Exception{
        return userRepository.findByEmail(email).orElseThrow(() -> new Exception(String.format("Email %s not found", email)));
    }
}
