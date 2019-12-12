package com.maycur.thirdapitest.api.mapper;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Create by HuQiuYue on 2019-11-08
 */
@Repository
@Transactional
public interface MeiyaBillMapper {
    Date getLastBillEndDate(@Param("entCode")String entCode);
}
