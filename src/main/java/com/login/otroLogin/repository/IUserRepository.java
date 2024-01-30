package com.login.otroLogin.repository;

import com.login.otroLogin.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository <User, Long>{
    Optional<User> findByUsername(String username);
}
