package com.maycur.thirdapitest.api.dto;

import lombok.Data;

/**
 * Create by HuQiuYue on 2019-10-18
 */
@Data
public class FlightSettlementResultDto {
    private String recordId;
    private String orderId;
    private Double amount;
    private Double postServiceFee;
    private Double itineraryFee;
    private String journeyNo;
}
