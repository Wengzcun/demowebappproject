package com.wzc.model.dao;

import lombok.Data;

@Data
public class LoginRequestDto {

    private String userId;

    private String password;

    private String phoneNumber;

    private String msgCode;
}
