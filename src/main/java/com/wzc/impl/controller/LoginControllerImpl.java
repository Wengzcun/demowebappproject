package com.wzc.impl.controller;

import com.wzc.interfaces.controller.LoginController;
import com.wzc.interfaces.service.LoginService;
import com.wzc.model.service.LoginRequsetVo;
import com.wzc.model.service.LoginResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class LoginControllerImpl implements LoginController {

    @Autowired
    private LoginService loginService;


    @Override
    public LoginResultVo login(LoginRequsetVo loginRequsetVo) {
        return loginService.login(loginRequsetVo);
    }
}
