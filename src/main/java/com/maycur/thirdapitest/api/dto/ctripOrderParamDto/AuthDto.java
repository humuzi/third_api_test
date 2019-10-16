package com.maycur.thirdapitest.api.dto.ctripOrderParamDto;

import lombok.Data;

/**
 * Create by HuQiuYue on 2019-10-12
 */
@Data
public class AuthDto extends RequestDto {
    private String AppKey;
    private String Ticket;

}
