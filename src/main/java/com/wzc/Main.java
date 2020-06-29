package com.wzc;

import com.wzc.interfaces.controller.LoginController;
import com.wzc.model.service.LoginRequsetVo;
import com.wzc.model.service.LoginResultVo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        System.setProperty("spring.profiles.active","dev");
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:spring/ApplicationContext.xml");

        LoginController loginController = (LoginController) context.getBean("loginControllerImpl");
        LoginRequsetVo loginRequsetVo = new LoginRequsetVo();
        loginRequsetVo.setUserId("123456789");
        loginRequsetVo.setPassword("123456");
        LoginResultVo loginResultVo = loginController.login(loginRequsetVo);
        System.out.println(loginResultVo.toString());
    }
}
