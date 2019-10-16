package com.maycur.thirdapitest.api.mapper;

import com.maycur.thirdapitest.api.dto.CtripEntInfoDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Create by HuQiuYue on 2019-09-05
 */
@Repository
@Transactional
public interface CtripEntInfoMapper {

    CtripEntInfoDto selectEntInfo(@Param("entCode") String entCode);
}
