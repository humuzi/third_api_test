package com.maycur.thirdapitest.front.runtime;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Create by HuQiuYue on 2019-05-07
 */
@Data
@Component
public class LoginUser {
    private String userCode;
    private String tokenId;
    private String refreshTokenId;
    private String entCode;
    private String userName;
}
