package com.wzc.impl.service;

import com.sun.istack.internal.NotNull;
import com.wzc.interfaces.dao.LoginDao;
import com.wzc.interfaces.service.LoginService;
import com.wzc.model.common.ErrorMsg;
import com.wzc.model.dao.LoginRequestDto;
import com.wzc.model.dao.LoginResultDto;
import com.wzc.model.service.LoginRequsetVo;
import com.wzc.model.service.LoginResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    @Override
    public LoginResultVo login(@NotNull LoginRequsetVo loginRequsetVo) {

        LoginResultVo loginResultVo = new LoginResultVo();

        LoginRequestDto loginRequestDto = new LoginRequestDto();
        loginRequestDto.setUserId(loginRequsetVo.getUserId());
        loginRequestDto.setPassword(loginRequsetVo.getPassword());
        loginRequestDto.setPhoneNumber(loginRequsetVo.getPhoneNumber());
        loginRequestDto.setMsgCode(loginRequsetVo.getMsgCode());
        LoginResultDto loginResultDto = loginDao.queryUserInfo(loginRequestDto);
        if(null == loginResultDto){
            ErrorMsg errorMsg = new ErrorMsg("0002","查询账户信息失败");
            loginResultVo.setErrorMsg(errorMsg);
            return loginResultVo;
        }
        loginResultVo.setUserName(loginResultDto.getUserName());
        loginResultVo.setUserId(loginResultDto.getUserId());
        loginResultVo.setToken(loginResultDto.getUserName() + loginResultDto.getUniversalId());
        loginResultVo.setErrorMsg(new ErrorMsg());
        return loginResultVo;
    }
}
