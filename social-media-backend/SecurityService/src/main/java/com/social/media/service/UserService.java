package com.social.media.service;

import com.social.media.dto.JwtAuthenticationDto;
import com.social.media.dto.RefreshTokenDto;
import com.social.media.dto.UserCredentialsDto;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
public interface UserService {
    JwtAuthenticationDto signIn(UserCredentialsDto userCredentialsDto) throws AuthenticationException;
    JwtAuthenticationDto refreshToken(RefreshTokenDto refreshTokenDto) throws Exception;
}
