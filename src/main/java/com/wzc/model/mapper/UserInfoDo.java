package com.wzc.model.mapper;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class UserInfoDo {

    @Id
    private Long id;

    @Column(name="user_id")
    private String userId;

    @Column(name="user_name")
    private String userName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "universal_id")
    private String universalId;
}
