package com.maycur.thirdapitest.mapper;

import com.maycur.thirdapitest.dto.CtripEntInfoDto;
import org.apache.ibatis.annotations.Param;

/**
 * Create by HuQiuYue on 2019-09-05
 */
public interface CtripEntInfo {

    CtripEntInfoDto selectEntInfo(@Param("entCode") String entCode);
}
