package com.maycur.thirdapitest.mobile.dto;

import lombok.Data;

/**
 * Create by HuQiuYue on 2019-11-28
 */
@Data
public class ResponseStatusDto extends CtripLoginFromHomeResultDto {
    private Boolean success;
    private String errorMessage;
}
