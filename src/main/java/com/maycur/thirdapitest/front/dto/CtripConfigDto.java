package com.maycur.thirdapitest.front.dto;

import lombok.Data;

import java.util.List;

/**
 * Create by HuQiuYue on 2019-11-13
 */
@Data
public class CtripConfigDto {
    private List priceTypes;
    private List cityTypes;
    private List reconciliations;
    private Boolean notificationEmail;
    private Boolean restrictDomesticClass;
    private List<CEmployeePropsDto> employeeProps;
    private List<CJourneyPropsDto> journeyProps;
    private Boolean extendJourneyDate;
    private Integer forwardDays;
    private Integer postponeDays;
    private List empOrderTypes;
    private String unifyReimbursePeriod;
    private Integer settlementSettingBits;
    private Integer unifyReimburseSettingBits;
    private Boolean restrictHotelAvgPrice;
    private Boolean restrictFlightSeatClass;
    private Integer restrictFlightBookingCount;
    private Boolean restrictIntlClass;
    private String hotelSpecialInvoiceFee;
    private String hotelAgreementServiceFee;
    private Integer bookForOthers;
    private Boolean restrictFlightPrice;
    private Boolean restrictHotelPrice;
    private Boolean restrictTrainPrice;
    private Boolean restrictFlightCity;
    private Boolean restrictHotelCity;
    private Boolean restrictTrainCity;
    private Integer authorizeType;
}
