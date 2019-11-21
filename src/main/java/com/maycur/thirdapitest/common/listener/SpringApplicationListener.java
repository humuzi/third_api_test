package com.maycur.thirdapitest.listener;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.ISuite;
import org.testng.ISuiteListener;

/**
 * Create by HuQiuYue on 2019-05-12
 */
public class SpringApplicationListener implements ISuiteListener {

   private static AnnotationConfigApplicationContext context;

    @Override
    public void onStart(ISuite suite) {
        context = new AnnotationConfigApplicationContext("com.maycur.thirdapitest");
    }

    @Override
    public void onFinish(ISuite suite) {
        context.close();
    }
}
