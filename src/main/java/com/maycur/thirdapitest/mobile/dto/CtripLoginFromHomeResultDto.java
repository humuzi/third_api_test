package com.maycur.thirdapitest.mobile.dto;

import lombok.Data;

/**
 * Create by HuQiuYue on 2019-11-28
 */
@Data
public class CtripLoginFromHomeResultDto {
    private ResponseStatusDto responseStatus;
    private String appKey;
    private String appId;
    private String token;
    private SsoLoginParamsDto ssoLoginParams;
    private String ssoLoginHtml;
}
