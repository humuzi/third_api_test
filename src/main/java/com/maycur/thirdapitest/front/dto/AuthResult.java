package com.maycur.thirdapitest.front.dto;
import lombok.Data;


import java.util.List;

/**
 * Create by HuQiuYue on 2019-04-18
 */
@Data
public class AuthResult {
    private String userCode;
    private String loginName;
    private String userName;
    private String tokenId;
    private boolean costCenterOwner;
    private boolean firstLogin;
    private String msg;
    private String mainPage;
    private String account;
    private List<String> roles;
    private Integer currencyRateFlag;
    private String lang;
    private List<EnterpriseDto> ents;
    private String mobile;
    private String email;
    private boolean vipUser;
    private String refreshTokenId;
    private boolean agree;
}
