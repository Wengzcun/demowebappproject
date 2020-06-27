package com.wzc.model.service;

import lombok.Data;

@Data
public class LoginRequsetVo {

    private String userId;

    private String password;

    private String phoneNumber;

    private String msgCode;
}
