package com.maycur.thirdapitest.api.dto;

import lombok.Data;

import java.util.List;

/**
 * Create by HuQiuYue on 2019-10-26
 */
@Data
public class LstHtlSettlementDto extends CtripHotelSettlementInfoDto {
    private String AccountId;
    private List<LstHotelSettlementDetailDto> LstHotelSettlementDetail;
}
