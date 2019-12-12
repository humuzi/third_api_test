package com.maycur.thirdapitest.mobile.pojo;

import lombok.Data;

/**
 * Create by HuQiuYue on 2019-11-28
 */
@Data
public class LoginUser {
    private String userCode;
    private String userName;
    private String tokenId;
    private String refreshTokenId;
}
