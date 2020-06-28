package com.wzc.impl.dao;

import com.wzc.impl.dao.datasource.MySQLProps;
import com.wzc.interfaces.dao.LoginDao;
import com.wzc.model.dao.LoginRequestDto;
import com.wzc.model.dao.LoginResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class LoginDaoImpl implements LoginDao {

    @Autowired
    private MySQLProps mySQLProps;

    @Override
    public LoginResultDto queryUserInfo(LoginRequestDto requestDto) {

        System.out.println("env = " + mySQLProps.getEnv());
        LoginResultDto loginResultDto = new LoginResultDto();

        if(requestDto != null){
            if(!StringUtils.isEmpty(requestDto.getUserId()) && !StringUtils.isEmpty(requestDto.getPassword())) {
                loginResultDto.setUserId(requestDto.getUserId());
                loginResultDto.setUserName("AccountLogin");
                loginResultDto.setUniversalId("ac123456789");
                return loginResultDto;
            }
            if(!StringUtils.isEmpty(requestDto.getPhoneNumber()) && !StringUtils.isEmpty(requestDto.getMsgCode())){
                loginResultDto.setUserId("ph123456789");
                loginResultDto.setUserName("PhoneNoLogin");
                loginResultDto.setUniversalId("ph123456789");
                return loginResultDto;
            }
        }
        return null;
    }
}
