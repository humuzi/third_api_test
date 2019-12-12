package com.maycur.thirdapitest.front.dto;

import lombok.Data;

import java.util.List;

/**
 * Create by HuQiuYue on 2019-11-14
 */
@Data
public class FanjiaConfigDto {
    private Integer authorizeType;
    private String paymentType;
    private Boolean reconBill;
    private Boolean unifyReimburseHotel;
    private Boolean unifyReimburseAirfare;
    private Boolean unifyReimburseTrain;
    private String unifyReimbursePeriod;
    private Integer flightPriceMode;
    private Integer hotelPriceMode;
    private Integer discount;
    private Integer lowestPrice;
    private Integer forwardDays;
    private Integer flightForwardDays;
    private Integer postponeDays;
    private String flightCityControlMode;
    private String hotelCityControlMode;
    private String flightCabinControlMode;
    private String flightPriceControlMode;
    private String hotelPriceControlMode;
    private String flightDateControlMode;
    private String hotelDateControlMode;
    private String hoursPriceControlMode;
    private String flightForwardControlMode;
    private Integer noApprovalType;
    private List<TMCNoApprovalScopeDto> tmcNoApprovalScopeDtos;
    private String endorseControlMode;

}
