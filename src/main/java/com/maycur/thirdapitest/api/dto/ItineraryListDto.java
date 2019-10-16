package com.maycur.thirdapitest.api.dto;

import lombok.Data;

import java.util.List;

/**
 * Create by HuQiuYue on 2019-10-10
 */
@Data
public class ItineraryListDto  extends CtripFlightOrderDto{
    private String JourneyNO;
    private List<FlightOrderInfoListDto> FlightOrderInfoList;
    private List<HotelOrderInfoListDto> HotelOrderInfoList;

}
