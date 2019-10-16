package com.maycur.thirdapitest.api.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Create by HuQiuYue on 2019-09-18
 */
@Data
public class FlightOrderResultDto {
    private String orderId;
    private String recordId;
    private String journeyNo;
    private Double consumeAmount;
    private String purpose;
    private String payType;
    private Double itineraryFee;
}
