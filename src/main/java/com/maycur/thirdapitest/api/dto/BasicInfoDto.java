package com.maycur.thirdapitest.api.dto;
import lombok.Data;
/**
 * Create by HuQiuYue on 2019-09-19
 */
@Data
public class BasicInfoDto extends FlightOrderInfoListDto {
    private String OrderID;
    private String JourneyID;
    private Double Amount;
    private String CorpPayType;
    private String PrepayType;
    private ServiceDetailInfoDto ServiceDetailInfo;
}
