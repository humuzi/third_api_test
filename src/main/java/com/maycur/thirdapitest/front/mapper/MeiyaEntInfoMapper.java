package com.maycur.thirdapitest.front.mapper;

import com.maycur.thirdapitest.front.pojo.MeiyaEntInfo;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Create by HuQiuYue on 2019-11-12
 */
@Repository
@Transactional
public interface MeiyaEntInfoMapper {
    MeiyaEntInfo getEntInfo(@Param("entCode") String entCode);
}
