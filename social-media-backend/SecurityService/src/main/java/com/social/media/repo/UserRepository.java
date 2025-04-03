package com.social.media.repo;

import com.social.media.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository {

    Optional<User> findByEmail(String username);
}
