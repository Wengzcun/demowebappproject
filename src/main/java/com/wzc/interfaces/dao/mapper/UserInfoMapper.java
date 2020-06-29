package com.wzc.interfaces.dao.mapper;

import com.wzc.model.mapper.UserInfoDo;

import java.util.List;

public interface UserInfoMapper {

    List<UserInfoDo> getUserInfos(UserInfoDo userInfo);

}
