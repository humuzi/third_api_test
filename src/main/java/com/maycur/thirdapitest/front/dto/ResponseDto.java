package com.maycur.thirdapitest.front.dto;
import lombok.Data;
/**
 * Create by HuQiuYue on 2019-04-18
 */
@Data
public class ResponseDto<T> {
    private String code;
    private String message;
    private T data;
    private Object[] args;
    private boolean linkDetail;
    private boolean nonBizError;
}
