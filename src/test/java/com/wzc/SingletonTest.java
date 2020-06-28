package com.wzc;

import com.wzc.impl.service.LoginServiceImpl;
import com.wzc.interfaces.controller.LoginController;
import com.wzc.interfaces.dao.LoginDao;
import com.wzc.interfaces.service.LoginService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertSame;

public class SingletonTest {

    private static ApplicationContext context;

    @BeforeClass
    public static void init(){
        context = new ClassPathXmlApplicationContext("classpath:spring/ApplicationContext.xml");
    }

    @Test
    public void testSameInstances(){
        LoginController controller1 = (LoginController) context.getBean("loginControllerImpl");
        LoginController controller2 =  (LoginController) context.getBean("loginControllerImpl");
        assertSame("Instances are not the same!",controller1, controller2);
    }

    @Test
    public void testDifferContext(){
        ClassPathXmlApplicationContext context2 = new ClassPathXmlApplicationContext("classpath:spring/ApplicationContext.xml");

        //scope针对的是同一个容器，不同的容器各自创建不同的bean
        LoginController controller1 = (LoginController) context.getBean("loginControllerImpl");
        LoginController controller2 =  (LoginController) context2.getBean("loginControllerImpl");
        assertSame("Instances are not the same!",controller1, controller2);
    }

    @Test
    public void testReference(){
        LoginServiceImpl service = (LoginServiceImpl) context.getBean("loginServiceImpl");
        LoginDao loginDao1 = (LoginDao)context.getBean("loginDaoImpl");
        LoginDao loginDao2 = service.loginDao;
        assertSame("Instances are not the same!",loginDao1, loginDao2);

    }


}
