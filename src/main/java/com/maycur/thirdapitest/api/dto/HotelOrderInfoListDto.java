package com.maycur.thirdapitest.api.dto;

import lombok.Data;

/**
 * Create by HuQiuYue on 2019-10-12
 */
@Data
public class HotelOrderInfoListDto extends ItineraryListDto {
    private String OrderID;
    private String JourneyNo;
    private double Amount;
    private String PayType;
    private String Corp_payType;
}
