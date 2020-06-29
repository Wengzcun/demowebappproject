package com.wzc.interfaces.dao.mapper;

import com.wzc.model.mapper.AuthorInfoDo;

public interface AuthorInfoMapper {

    AuthorInfoDo getAuthorInfo(AuthorInfoDo authorInfo);

    void saveAuthorInfo(AuthorInfoDo authorInfoDo);
}
