package com.wzc.impl.dao.datasource;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Profile({"dev","default"})
@PropertySource("classpath:property/mysqlDev")
//PropertySource作用读取mysqlDev信息，并将配置信息加载到Spring的Environment中(import org.springframework.core.env.Environment)
@Component("mySQLProps")
public class MySQLDevProps implements MySQLProps{


    @Value(value = "${mysql.dev.userName}")
    private String userName;

    @Value(value = "${mysql.dev.url}")
    private String url;

    @Value(value = "${mysql.dev.port}")
    private String port;

    @Value(value = "${mysql.dev.env}")
    private String env;

    @Override
    public String getEnv(){
        return env;
    }
}
