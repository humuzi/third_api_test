package com.maycur.thirdapitest.api.dto.ctripSettlementParamDto;

import lombok.Data;

/**
 * Create by HuQiuYue on 2019-10-18
 */
@Data
public class AuthDto extends CtripSettlementParamDto {
    private String AppKey;
    private String Ticket;
}
