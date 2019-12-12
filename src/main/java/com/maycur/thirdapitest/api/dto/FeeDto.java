package com.maycur.thirdapitest.api.dto;

import lombok.Data;

import java.util.Date;

/**
 * Create by HuQiuYue on 2019-11-07
 */
@Data
public class FeeDto extends FanjiaReconcilingBillDetailsDto {
    private Double consumeAmount;
    private String consumeCcyCode;
    private Date consumeDate;
    private String departmentCode;
    private String departmentName;
    private String employeeId;
    private String employeeName;
    private String entCode;
    private String feeCode;
    private String markAsLoan;
    private String orderType;
    private String preCode;
    private String preDataCode;
    private String preFeeCode;
    private String reimCode;
    private String reimDataCode;
    private String sourceId;
    private String subsidiaryCode;
    private String subsidiaryName;
    private String tmcPreStatus;
    private String tmcReimStatus;
    private String userCode;
}
