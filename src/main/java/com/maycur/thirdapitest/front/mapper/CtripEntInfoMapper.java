package com.maycur.thirdapitest.front.mapper;

import com.maycur.thirdapitest.front.pojo.CtripEntInfo;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Create by HuQiuYue on 2019-11-13
 */
@Repository
@Transactional
public interface CtripEntInfoMapper {
    CtripEntInfo getEntInfo(@Param("entCode") String entCode);
}
