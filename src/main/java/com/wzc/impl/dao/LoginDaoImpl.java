package com.wzc.impl.dao;

import com.wzc.impl.dao.datasource.MySQLProps;
import com.wzc.interfaces.dao.LoginDao;
import com.wzc.interfaces.dao.mapper.AuthorInfoMapper;
import com.wzc.interfaces.dao.mapper.UserInfoMapper;
import com.wzc.model.dao.LoginRequestDto;
import com.wzc.model.dao.LoginResultDto;
import com.wzc.model.enumclass.AuthorType;
import com.wzc.model.mapper.AuthorInfoDo;
import com.wzc.model.mapper.UserInfoDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

@Component
public class LoginDaoImpl implements LoginDao {

    @Autowired
    private MySQLProps mySQLProps;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private AuthorInfoMapper authorInfoMapper;


    @Transactional
    @Override
    public LoginResultDto queryUserInfo(LoginRequestDto requestDto) {

        System.out.println("env = " + mySQLProps.getEnv());
        LoginResultDto loginResultDto = new LoginResultDto();

        if(requestDto != null){
            if(!StringUtils.isEmpty(requestDto.getUserId()) && !StringUtils.isEmpty(requestDto.getPassword())) {

                //check author info
                AuthorInfoDo authorInfoRequest = new AuthorInfoDo();
                authorInfoRequest.setUserId(requestDto.getUserId());
                authorInfoRequest.setPassword(requestDto.getPassword());
                authorInfoRequest.setAuthorType(AuthorType.LOGIN.getAuthorType());

                AuthorInfoDo authorInfoResult = authorInfoMapper.getAuthorInfo(authorInfoRequest);
                if(authorInfoResult == null){
                    return null;
                }

                //query user information
                UserInfoDo userInfoDo = new UserInfoDo();
                userInfoDo.setUserId(requestDto.getUserId());
                UserInfoDo userInfoResult = userInfoMapper.getUserInfo(userInfoDo);
                if(userInfoResult != null){
                    loginResultDto.setUserId(userInfoResult.getUserId());
                    loginResultDto.setUserName(userInfoResult.getUserName());
                    loginResultDto.setUniversalId(userInfoResult.getUniversalId());
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
