package com.maycur.thirdapitest.mobile.dto;

import lombok.Data;

/**
 * Create by HuQiuYue on 2019-12-03
 */
@Data
public class CtripLoginFromTravelManageResultDto {
    private ResponseStatus2Dto responseStatus;
    private String appKey;
    private String appId;
    private String token;
    private SsoLoginParams2Dto ssoLoginParams;
    private String ssoLoginHtml;
}
