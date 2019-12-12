package com.maycur.thirdapitest.front.dto;

import lombok.Data;

/**
 * Create by HuQiuYue on 2019-11-12
 */
@Data
public class EmployeePropsDto extends MeiyaConfigDto {
    private String code;
    private String name;
    private Boolean selected;
    private String text;
}
