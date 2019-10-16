package com.maycur.thirdapitest.api.dto.ctripOrderParamDto;

import lombok.Data;

/**
 * Create by HuQiuYue on 2019-10-12
 */
@Data
public class RequestDto extends CtripOrderParamDto {
    private AuthDto Auth;
    private String OrderID;
    private String SearchType;
}
