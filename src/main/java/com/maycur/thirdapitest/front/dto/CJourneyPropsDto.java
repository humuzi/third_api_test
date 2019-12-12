package com.maycur.thirdapitest.front.dto;

import lombok.Data;

/**
 * Create by HuQiuYue on 2019-11-13
 */
@Data
public class CJourneyPropsDto extends CtripConfigDto {
    private String code;
    private String name;
    private Boolean selected;
}
