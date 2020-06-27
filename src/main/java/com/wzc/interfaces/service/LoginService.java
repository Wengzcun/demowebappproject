package com.wzc.interfaces.service;

import com.wzc.model.service.LoginRequsetVo;
import com.wzc.model.service.LoginResultVo;

public interface LoginService {

    LoginResultVo login(LoginRequsetVo loginRequsetVo);
}
