package com.maycur.thirdapitest.api.dto;

import lombok.Data;

/**
 * Create by HuQiuYue on 2019-10-12
 */
@Data
public class HotelOrderResultDto {
    private String orderId;
    private String recordId;
    private String journeyId;
    private Double amount;
    private String payType;
    private String corpPayType;
}
