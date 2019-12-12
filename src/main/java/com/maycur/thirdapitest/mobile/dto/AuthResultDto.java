package com.maycur.thirdapitest.mobile.dto;

import lombok.Data;

import java.util.List;

/**
 * Create by HuQiuYue on 2019-11-28
 */
@Data
public class AuthResultDto{
    private String userCode;
    private String loginName;
    private String userName;
    private String tokenId;
    private String msg;
    private String mainPage;
    private String account;
    private List<String> roles;
    private String currencyRateFlag;
    private String lang;
    private List<EntDto> ents;
    private String mobile;
    private String email;
    private Boolean vipUser;
    private String refreshTokenId;
    private Boolean agree;
    private Boolean firstLogin;
    private Boolean costCenterOwner;
}
