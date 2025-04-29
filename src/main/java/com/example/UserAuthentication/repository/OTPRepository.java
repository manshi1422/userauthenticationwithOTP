package com.example.UserAuthentication.repository;

import com.example.UserAuthentication.model.OTP;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OTPRepository extends JpaRepository<OTP, String> {}