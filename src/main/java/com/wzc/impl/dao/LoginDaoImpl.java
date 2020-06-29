package com.wzc.impl.dao;

import com.wzc.impl.dao.datasource.MySQLProps;
import com.wzc.interfaces.dao.LoginDao;
import com.wzc.interfaces.dao.mapper.UserInfoMapper;
import com.wzc.model.dao.LoginRequestDto;
import com.wzc.model.dao.LoginResultDto;
import com.wzc.model.mapper.UserInfoDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

@Component
public class LoginDaoImpl implements LoginDao {

    @Autowired
    private MySQLProps mySQLProps;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public LoginResultDto queryUserInfo(LoginRequestDto requestDto) {

        System.out.println("env = " + mySQLProps.getEnv());
        LoginResultDto loginResultDto = new LoginResultDto();

        if(requestDto != null){
            if(!StringUtils.isEmpty(requestDto.getUserId()) && !StringUtils.isEmpty(requestDto.getPassword())) {

                UserInfoDo userInfoDo = new UserInfoDo();
                userInfoDo.setUserId(requestDto.getUserId());
                List<UserInfoDo> userInfoDoList = userInfoMapper.getUserInfos(userInfoDo);
                if(!CollectionUtils.isEmpty(userInfoDoList)){
                    loginResultDto.setUserId(userInfoDoList.get(0).getUserId());
                    loginResultDto.setUserName(userInfoDoList.get(0).getUserName());
                    loginResultDto.setUniversalId(userInfoDoList.get(0).getUniversalId());
                    return loginResultDto;
                }
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
