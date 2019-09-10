package com.test;

import com.maycur.thirdapitest.runtime.LoginUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Create by HuQiuYue on 2019-09-10
 */
public class TestCase {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/Users/Lee/Documents/third_api_test/src/main/resources/spring-mybatis.xml");
        LoginUser lu= ctx.getBean(LoginUser.class);
        System.out.println(lu.getTokenId());
    }
}
