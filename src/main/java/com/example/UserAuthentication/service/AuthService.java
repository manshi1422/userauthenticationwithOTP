package com.example.UserAuthentication.service;

import com.example.UserAuthentication.dto.OTPVerifyRequest;
import com.example.UserAuthentication.dto.SignupRequest;
import com.example.UserAuthentication.model.User;
import com.example.UserAuthentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OTPService otpService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthService() {
    }

    public String registerUser(SignupRequest request) {
        User existingUser = this.userRepository.findFirstByMobile(request.getMobile());
        System.out.println(existingUser);
        if (existingUser != null && existingUser.isActive()) {
            return existingUser.isActive() ? "user already exists" : "";
        } else {
            User user = new User();
            user.setEmail(request.getEmail());
            user.setPassword(this.passwordEncoder.encode(request.getPassword()));
            user.setMobile(request.getMobile());
            user.setMobileVerified(false);
            user.setActive(false);
            this.userRepository.save(user);
            this.otpService.generateOtp(request.getMobile());
            return "otp sent";
        }
    }

    public String verifyOtp(OTPVerifyRequest request) {
        boolean valid = this.otpService.validateOtp(request.getMobile(), request.getCode());
        if (!valid) {
            return "Invalid OTP";
        } else {
            User user = this.userRepository.findFirstByMobile(request.getMobile());
            user.setMobileVerified(true);
            user.setActive(true);
            this.userRepository.save(user);
            return "Verification successful (token here)";
        }
    }
}