package com.maycur.thirdapitest.api.mapper;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Create by HuQiuYue on 2019-11-05
 */
@Repository
@Transactional
public interface FanjiaBillMapper {
    int getbillsNum(@Param("entCode") String entCode,@Param("status") String status);

    int getBillDetailsNum(@Param("entCode") String entCode,@Param("reconBillCode") String reconBillCode);
}
