package com.maycur.thirdapitest.common.util;

/**
 * Create by HuQiuYue on 2019-05-15
 */
public class ConfigUtil {

    public String getBaseUrl(){

        return "https://dev.maycur.com/api/web";
    }

    public String getTestDataPath(){
        return "src/main/resources/testdata";
    }

    public String getMobileBaseUrl(){
        return "https://dev.maycur.com/api/mobile";
    }
}
