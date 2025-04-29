package com.example.UserAuthentication.dto;

public class OTPVerifyRequest {
    private String mobile;
    private String code;

    public OTPVerifyRequest() {
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}