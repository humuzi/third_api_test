package com.maycur.thirdapitest.common.constant;

/**
 * Create by HuQiuYue on 2019-11-22
 */
public final class Constant {


    //    携程管理页面
    public static final String CTRIP_CONFIG_URL = "/ctrip/changeConfigurableAttr";
    public static final String CTRIP_SYNC_EMPLOYEES_URL = "/ctrip/syncEmployees";
    public static final String CTRIP_RULE_SETTING_URL = "/ctrip/unification_switch";
    public static final String CTRIP_SUB_ACCOUNT_EXCEPTION_EMPLOYEE_URL = "/ctrip/exception_member/SUB_ACCOUNT_UNIFICATION";
    public static final String CTRIP_CONFIRM_PERSON_EXCEPTION_EMPLOYEE_URL = "/ctrip/exception_member/CONFIRM_PERSON_UNIFICATION";
    public static final String CTRIP_CONFIRM2_PERSON_EXCEPTION_EMPLOYEE_URL = "/ctrip/exception_member/SECOND_CONFIRM_PERSON_UNIFICATION";
    public static final String CTRIP_RULE_SETTING_UPDATE_URL = "/ctrip/employee_extend_property";

//    泛嘉管理页面
    public static final String FANJIA_CONFIG_URL = "/fanjia/changeConfigurableAttr";
    public static final String FANJIA_SYNC_EMPLOYEES_URL = "/fanjia/sync/employees";

//    美亚管理页面
    public static final String MEIYA_CONFIG_URL = "/meiya/changeConfigurableAttr";
    public static final String MEIYA_SYNC_EMPLOYEES_URL = "/meiya/syncEmployees/";
    public static final String MEIYA_SYNC_APPROVER_URL = "/meiya/syncApprover";

//    对账页面
    public static final String UNRECONCILED_TMC_BILLS_URL = "/tmc/settlement-bill/get-unreconciled-tmc-bills";
    public static final String UPLOAD_TMC_BILLS_URL = "/tmc/upload/ctrip-settlement-bill";
    public static final String FETCH_FANJIA_BILL_URL = "/tmc/settlement-bill/refresh-new-bills/fanjia";
    public static final String FETCH_MEIYA_BILL_URL = "/tmc/settlement-bill/refresh-new-bills-with-criteria/meiya";


//    手机端

//    携程登录token
    public static final String MOBILE_LOGIN_URL = "/auth/login";
    public static final String CTRIP_TOKEN_URL = "/ctrip/getLoginAuth";
    public static final String CTRIP_H5_LOGIN_URL = "https://ct.ctrip.com/m/SingleSignOn/H5SignInfo";
}

