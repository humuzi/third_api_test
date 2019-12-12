package com.maycur.thirdapitest.front.pojo;


import lombok.Data;

/**
 * Create by HuQiuYue on 2019-11-12
 */
@Data
public class MeiyaEntInfo {
    private Boolean quartzSyncEmployee;
    private Boolean employeeContainsMobile;
    private Boolean employeeContainsEmail;
    private Boolean employeeContainsRank;
    private Boolean employeeContainsSubsidiary;
    private Boolean hotelBooking;
    private Boolean flightBooking;
    private Integer authorizeType;
    private Boolean journeyContainsDepartment;
    private Boolean journeyContainsSubsidiary;
    private Boolean journeyContainsCompanion;
    private Boolean journeyContainsCostCenter;
    private Boolean restrictFlightCity;
    private Boolean restrictHotelCity;
    private Boolean monthlyCheckOrder;
    private Boolean reconHotelBill;
    private Boolean reconFlightBill;
    private Boolean unifyReimFlight;
    private Boolean unifyReimHotel;
    private Integer reimCycle;
    private Boolean syncApprover;
}
