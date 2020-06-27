package com.wzc.interfaces.dao;

import com.wzc.model.dao.LoginRequestDto;
import com.wzc.model.dao.LoginResultDto;

public interface LoginDao {

    LoginResultDto queryUserInfo(LoginRequestDto requestDto);
}
