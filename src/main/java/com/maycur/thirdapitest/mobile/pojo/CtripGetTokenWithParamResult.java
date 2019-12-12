package com.maycur.thirdapitest.mobile.pojo;

import lombok.Data;

/**
 * Create by HuQiuYue on 2019-12-03
 */
@Data
public class CtripGetTokenWithParamResult {
    private String appKey;
    private String appId;
    private String token;
    private String CorpPayType;
    private String ACityCode;
    private String Callback;
    private String InitPage;
    private String DCityCode;
    private String FlightSearchType;
    private String ClassType;
    private String Adate;
    private String Ddate;
}
