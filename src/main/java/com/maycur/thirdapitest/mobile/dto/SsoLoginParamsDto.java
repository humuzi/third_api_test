package com.maycur.thirdapitest.mobile.dto;

import lombok.Data;

/**
 * Create by HuQiuYue on 2019-11-28
 */
@Data
public class SsoLoginParamsDto extends CtripLoginFromHomeResultDto {
    private String AppID;
    private String AppKey;
}
