package com.maycur.thirdapitest.front.mapper;

import com.maycur.thirdapitest.front.pojo.FanjiaEntInfo;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Create by HuQiuYue on 2019-11-15
 */
@Repository
@Transactional
public interface FanjiaEntInfoMapper {
    FanjiaEntInfo getEntConfig(@Param("entCode") String entCode);
}
