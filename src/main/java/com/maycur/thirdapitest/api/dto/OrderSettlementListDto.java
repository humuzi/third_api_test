package com.maycur.thirdapitest.api.dto;

import lombok.Data;

/**
 * Create by HuQiuYue on 2019-10-18
 */
@Data
public class OrderSettlementListDto extends FlightOrderAccountSettlementListDto {
    private OrderSettlementBaseInfoDto OrderSettlementBaseInfo;
    private OrderBaseInfoDto OrderBaseInfo;

}
