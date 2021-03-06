package com.maycur.thirdapitest.common.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Create by HuQiuYue on 2019-05-14
 */
public class MyRetry implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int maxRetryCount = 1;

    @Override
    public boolean retry(ITestResult result){
        if(retryCount < maxRetryCount){
            retryCount++;
            return true;
        }
        return true;
    }
}
