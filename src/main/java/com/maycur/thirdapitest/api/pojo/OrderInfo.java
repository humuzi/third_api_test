package com.maycur.thirdapitest.api.pojo;
import lombok.Data;
/**
 * Create by HuQiuYue on 2019-09-19
 */
@Data
public class OrderInfo {
    private String orderId;
    private String recordId;
    private String journeyNo;
    private String consumeAmount;
    private String purpose;
    private String payType;
    private String itineraryFee;
    private String postAmount;
}
