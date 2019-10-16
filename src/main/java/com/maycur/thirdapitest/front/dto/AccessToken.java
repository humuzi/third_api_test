package com.maycur.thirdapitest.front.dto;

import lombok.Data;

/**
 * Create by HuQiuYue on 2019-06-13
 */
@Data
public class AccessToken {
    private String accessToken;
    private long expiresIn;
    private String tokenType;
    private String scope;

    public AccessToken(String accessToken, long expiresTime, String tokenType, String scope) {
        this.accessToken = accessToken;
        this.expiresIn = System.currentTimeMillis() + (expiresTime - 300) * 1000;
        this.tokenType = tokenType;
        this.scope = scope;
    }
}
