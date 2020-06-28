package com.wzc.impl.dao.datasource;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Data
@Profile("prod")
@Component
public class MySQLProdProps implements MySQLProps{

    @Value("${mysql.prod.userName}")
    private String userName;

    @Value("${mysql.prod.url}")
    private String url;

    @Value("${mysql.prod.port}")
    private int port;

    @Value("${mysql.prod.env}")
    private String env;

    @Override
    public String getEnv(){
        return env;
    }

}
