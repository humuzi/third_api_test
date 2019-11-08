package com.maycur.thirdapitest.api.mapper;

import com.maycur.thirdapitest.api.pojo.OrderInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Create by HuQiuYue on 2019-10-10
 */
@Repository
@Transactional
public interface CtripHotelOrderInfoMapper {

    OrderInfo getHotelOrderInfo(@Param("entCode") String entCode,@Param("orderId") String orderId);

    OrderInfo getHotelSettlementInfo(@Param("entCode") String entCode,@Param("recordId") String recordId);
}
