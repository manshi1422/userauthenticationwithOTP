package com.example.UserAuthentication.repository;

import com.example.UserAuthentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstByMobile(String mobile);
}