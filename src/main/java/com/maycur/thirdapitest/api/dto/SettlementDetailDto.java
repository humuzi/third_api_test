package com.maycur.thirdapitest.api.dto;

import lombok.Data;

/**
 * Create by HuQiuYue on 2019-10-26
 */
@Data
public class SettlementDetailDto extends LstHotelSettlementDetailDto {
    private String RecordId;
    private String OrderID;
    private Double Amount;
    private Double Servicefee;
    private Double ExtraCharge;
}
