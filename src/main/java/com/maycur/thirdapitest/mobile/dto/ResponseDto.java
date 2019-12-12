package com.maycur.thirdapitest.mobile.dto;

import lombok.Data;

/**
 * Create by HuQiuYue on 2019-11-28
 */
@Data
public class ResponseDto<T> {
    private String code;
    private String message;
    private T data;
    private Object[] args;
    private Boolean linkDetail;
    private Boolean nonBizError;
}
