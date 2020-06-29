package com.wzc.model.mapper;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class AuthorInfoDo {

    @Id
    private Long id;

    @Column(name="user_id")
    private String userId;

    @Column(name="password")
    private String password;

    @Column(name = "author_type")
    private int authorType;

    @Column(name = "universal_id")
    private String universalId;
}
