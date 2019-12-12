package com.maycur.thirdapitest.api.dto;

import lombok.Data;

/**
 * Create by HuQiuYue on 2019-11-07
 */
@Data
public class FanjiaReconcilingBillDetailsDto  {
    private String code;
    private String sourceId;
    private String comments;
    private Boolean deleted;
    private Boolean flag;
    private String reconResult;
    private String reconcileBillCode;
    private String reconcileBillPaymentStatus;
    private String subsidiaryReconcileBillCode;
    private ChargeDto chargeDto;
    private FeeDto feeDto;
}
