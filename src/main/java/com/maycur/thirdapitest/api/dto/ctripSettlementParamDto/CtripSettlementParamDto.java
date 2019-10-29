package com.maycur.thirdapitest.api.dto.ctripSettlementParamDto;

import lombok.Data;

import java.util.Date;

/**
 * Create by HuQiuYue on 2019-10-18
 */
@Data
public class CtripSettlementParamDto {
    private AuthDto auth;
    private Date DateFrom;
    private Date DateTo;
    private String RecordID;
}
