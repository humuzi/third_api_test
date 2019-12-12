package com.maycur.thirdapitest.api.mapper;

import com.maycur.thirdapitest.api.pojo.OrderInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Create by HuQiuYue on 2019-09-17
 */
@Repository
@Transactional
public interface CtripFlightInfoMapper {
    OrderInfo selectFlightOrder(@Param("entCode") String entCode, @Param("orderId") String orderId);

    OrderInfo getFlightSettlementInfo(@Param("entCode")String entCode,@Param("recordId") String recordId);


}
