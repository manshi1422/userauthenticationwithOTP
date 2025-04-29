package com.example.UserAuthentication.controller;

import com.example.UserAuthentication.dto.OTPVerifyRequest;
import com.example.UserAuthentication.dto.SignupRequest;
import com.example.UserAuthentication.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    public AuthController() {
    }

    @PostMapping({"/register"})
    public ResponseEntity<String> register(@Valid @RequestBody SignupRequest request) {
        String isOK = this.authService.registerUser(request);
        return isOK.equals("user already exists") ? ResponseEntity.badRequest().body("User already exists") : ResponseEntity.ok("otp sent");
    }

    @PostMapping({"/verify-otp"})
    public ResponseEntity<String> verifyOtp(@RequestBody OTPVerifyRequest request) {
        return this.authService.verifyOtp(request).equals("Invalid OTP") ? ResponseEntity.badRequest().body("Invalid OTP") : ResponseEntity.ok(this.authService.verifyOtp(request));
    }
}