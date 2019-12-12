package com.maycur.thirdapitest.front.dto;

import lombok.Data;

import java.util.List;

/**
 * Create by HuQiuYue on 2019-11-12
 */
@Data
public class MeiyaConfigDto {
    private Boolean restrictCityHotel;
    private Boolean employeeContainsRank;
    private Boolean reconBillHotel;
    private String userCode;
    private Integer authorizeType;
    private Boolean journeyContainsSubsidiary;
    private Boolean unifyReimburseFlight;
    private Long serialVersionUID;
    private Boolean employeeContainsDeptCostCenterCode;
    private Boolean journeyContainsDepartment;
    private Boolean journeyContainsCompanion;
    private Integer entReimburseCycle;
    private Boolean employeeContainsSubsidiary;
    private String key;
    private Boolean employeeContainsMobile;
    private Boolean flightBooking;
    private String employeeName;
    private String secretKey;
    private Boolean restrictCityFlight;
    private String employeeId;
    private Boolean hotelBooking;
    private Boolean syncApprover;
    private String adminName;
    private String companyId;
    private String adminPhone;
    private Boolean employeeContainsDepartment;
    private String entCode;
    private Boolean monthlyCheckOrder;
    private Boolean unifyReimburseHotel;
    private Boolean employeeContainsEmail;
    private List<EmployeePropsDto> employeeProps;
    private List<JourneyPropsDto> journeyProps;
}
