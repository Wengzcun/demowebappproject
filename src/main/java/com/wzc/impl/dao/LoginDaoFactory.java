package com.wzc.impl.dao;

import com.wzc.interfaces.dao.LoginDao;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class LoginDaoFactory implements FactoryBean<LoginDao> {
    @Override
    public LoginDao getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
