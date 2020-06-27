package com.wzc.impl.dao;

import com.wzc.interfaces.dao.LoginDao;
import com.wzc.model.dao.LoginRequestDto;
import com.wzc.model.dao.LoginResultDto;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class LoginDaoImpl implements LoginDao {

    @Override
    public LoginResultDto queryUserInfo(LoginRequestDto requestDto) {
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
