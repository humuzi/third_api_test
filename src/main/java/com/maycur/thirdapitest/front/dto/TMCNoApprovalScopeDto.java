package com.maycur.thirdapitest.front.dto;

import lombok.Data;

/**
 * Create by HuQiuYue on 2019-11-14
 */
@Data
public class TMCNoApprovalScopeDto extends FanjiaConfigDto {
    private String bizCode;
    private String entCode;
    private String scopeType;
    private String thirdPartyCode;
}
