package com.maycur.thirdapitest.front.pojo;

import lombok.Data;

/**
 * Create by HuQiuYue on 2019-11-13
 */
@Data
public class CtripEntInfo {
    private Integer authorizeType;
    private Boolean bookForEmployees;
    private Boolean restrictHotelCity;
    private Boolean restrictFlightCity;
    private Boolean restrictTrainCity;
    private Boolean restrictHotelPrice;
    private Boolean restrictFlightPrice;
    private Boolean restrictTrainPrice;
    private Boolean journeyContainsCompanion;
    private Boolean employeeContainsSubsidiary;
    private Boolean employeeContainsDepartment;
    private Boolean employeeContainsRank;
    private Boolean employeeContainsConfirmPerson;
    private Boolean employeeContainsConfirmPerson2;
    private Boolean employeeContainsInvoiceTitle;
    private Integer bookForOthers;
    private Boolean restrictDomesticClass;
    private Boolean extendJourneyDate;
    private Integer forwardDays;
    private Integer postponeDays;
    private Boolean ignoreHotelCity;
    private Boolean restrictFlightSeatClass;
    private Integer settlementSettingBits;
    private Integer unifyReimburseSettingBits;
    private String unifyReimbursePeriod;
    private Integer restrictFlightBookCount;
    private Boolean restrictHotelAvgPrice;
    private Boolean restrictIntlClass;
    private String hotelSpecialInvoiceFee;
    private String hotelAgreementServiceFee;
}
