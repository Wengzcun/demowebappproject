package com.wzc.interfaces.controller;

import com.wzc.model.service.LoginRequsetVo;
import com.wzc.model.service.LoginResultVo;


public interface LoginController {

    //登陆接口
    LoginResultVo login(LoginRequsetVo loginRequsetVo);

}
