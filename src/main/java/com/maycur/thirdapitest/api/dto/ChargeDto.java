package com.maycur.thirdapitest.api.dto;

import lombok.Data;

import java.util.Date;

/**
 * Create by HuQiuYue on 2019-11-07
 */
@Data
public class ChargeDto extends FanjiaReconcilingBillDetailsDto {
    private Double billAmount;
    private String billCcyCode;
    private Date billDate;
    private String billId;
    private String employeeId;
    private String employeeName;
    private String journeyNo;
    private String sourceId;
    private String userCode;
}
