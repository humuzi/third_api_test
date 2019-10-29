package com.maycur.thirdapitest.api.dto;

import lombok.Data;

/**
 * Create by HuQiuYue on 2019-10-29
 */
@Data
public class HotelSettlementResultDto {
    private String recordId;
    private String orderId;
    private Double amount;
    private Double serviceFee;
    private String journeyNo;
}
