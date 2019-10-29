package com.maycur.thirdapitest.api.dto;

import lombok.Data;

import java.util.List;

/**
 * Create by HuQiuYue on 2019-09-17
 */
@Data
public class CtripOrderInfoDto {
    private List<ItineraryListDto> itineraryList;

}
