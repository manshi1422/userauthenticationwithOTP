package com.example.UserAuthentication.service;

import com.example.UserAuthentication.model.OTP;
import com.example.UserAuthentication.repository.OTPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class OTPService {
    @Autowired
    private OTPRepository otpRepository;

    public OTPService() {
    }

    public void generateOtp(String mobile) {
        String code = String.format("%06d", (new Random()).nextInt(999999));
        OTP otp = new OTP();
        otp.setMobile(mobile);
        otp.setCode(code);
        otp.setExpiresAt(LocalDateTime.now().plusMinutes(5L));
        this.otpRepository.save(otp);
        System.out.println("OTP sent to mobile: " + code);
    }

    public boolean validateOtp(String mobile, String code) {
        return this.otpRepository.findById(mobile).filter((o) -> {
            return o.getCode().equals(code) && o.getExpiresAt().isAfter(LocalDateTime.now());
        }).isPresent();
    }
}