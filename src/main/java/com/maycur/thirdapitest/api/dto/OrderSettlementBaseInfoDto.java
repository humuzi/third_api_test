package com.maycur.thirdapitest.api.dto;

import lombok.Data;

/**
 * Create by HuQiuYue on 2019-10-18
 */
@Data
public class OrderSettlementBaseInfoDto extends OrderSettlementListDto {
    private String RecordID;
    private String OrderID;
    private Double Amount;
    private Double ItineraryFee;
    private Double PostServiceFee;
}
