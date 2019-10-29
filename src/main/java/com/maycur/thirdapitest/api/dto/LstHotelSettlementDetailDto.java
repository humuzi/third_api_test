package com.maycur.thirdapitest.api.dto;

import lombok.Data;

/**
 * Create by HuQiuYue on 2019-10-26
 */
@Data
public class LstHotelSettlementDetailDto extends LstHtlSettlementDto {
    private SettlementDetailDto SettlementDetailDto;
    private OrderDetailDto OrderDetail;
}
