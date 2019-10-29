package com.maycur.thirdapitest.api.dto;

import lombok.Data;

import java.util.List;

/**
 * Create by HuQiuYue on 2019-10-18
 */
@Data
public class CtripFlightSettlementInfoDto {
    private List<FlightOrderAccountSettlementListDto> FlightOrderAccountSettlementList;
}
