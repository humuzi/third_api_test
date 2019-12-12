package com.maycur.thirdapitest.front.pojo;

import lombok.Data;

/**
 * Create by HuQiuYue on 2019-11-15
 */
@Data
public class FanjiaEntInfo {
    private Integer authorizeType;
    private Boolean restrictCity;
    private Boolean restrictPrice;
    private Integer restrictLevel;
    private Boolean restrictEndorse;
    private String paymentType;
    private Boolean reconBill;
    private Boolean unifyReimburseHotel;
    private Boolean unifyReimburseAirfare;
    private Boolean unifyReimburseTrain;
    private String unifyReimbursePeriod;
    private Integer hotelPriceMode;
    private Integer flightPriceMode;
    private Integer discount;
    private Integer forwardDays;
    private Integer postponeDays;
    private String flightCityControlMode;
    private String hotelCityControlMode;
    private String flightPriceControlMode;
    private String hotelPriceControlMode;
    private Integer lowestPrice;
    private Integer noApprovalType;
    private String endorseControlMode;
    private String flightCabinControlMode;
    private String flightDateControlMode;
    private String hotelDateControlMode;
    private String hoursPriceControlMode;
    private String flightForwardControlMode;
    private Integer flightForwardDays;
}
