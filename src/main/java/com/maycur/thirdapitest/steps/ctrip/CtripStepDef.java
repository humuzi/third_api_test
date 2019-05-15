package com.maycur.thirdapitest.steps.ctrip;



import io.restassured.response.Response;
import org.json.JSONObject;

import org.springframework.stereotype.Component;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import com.maycur.thirdapitest.steps.auth.*;


/**
 * Create by HuQiuYue on 2019-05-07
 */
@Component
public class CtripStepDef {

    AuthStepDef auth = new AuthStepDef();

    /**
     * 设置subAccount例外人员
     */
    @Test(groups = {"humuzi"})
    public void setSubAccountException(){
        JSONObject jsonObject = new JSONObject().put("memberDtos","[\n" +
                "{\n" +
                "\"entCode\":\"EC1704131UT5KW00\",\n" +
                "\"unificationSwitchType\":\"SUB_ACCOUNT_UNIFICATION\",\n" +
                "\"userCode\":\"UI18040313768S1W\",\n" +
                "\"name\":\"小黑\",\n" +
                "\"subAccount\":\"Mango\",\n" +
                "\"confirmPerson\":null,\n" +
                "\"confirmPerson2\":null\n" +
                "},\n" +
                "{\n" +
                "\"entCode\":\"EC1704131UT5KW00\",\n" +
                "\"unificationSwitchType\":\"SUB_ACCOUNT_UNIFICATION\",\n" +
                "\"userCode\":\"UI1803221NEY7W41\",\n" +
                "\"name\":\"小白\",\n" +
                "\"subAccount\":\"Cheery\",\n" +
                "\"confirmPerson\":null,\n" +
                "\"confirmPerson2\":null\n" +
                "}\n" +
                "]")
                .put("type","SUB_ACCOUNT_UNIFICATION");

        Response response = given().accept("application/json")
                .header("entCode","EC1704131UT5KW00")
                .header("tokenId",auth.adminLogin().getTokenId())
                .body(jsonObject.toString())
                .post("https://dev.maycur.com/api/web/ctrip/exception_member/SUB_ACCOUNT_UNIFICATION");

        assertThat(response.getBody().asString(),response.getStatusCode(),equalTo(200));
        assertThat(response.getBody().asString(),response.getBody().jsonPath().get("code"),equalTo("ACK"));
    }

    /**
     * 更新携程员工Extend_property
     */

    @Test(groups = {"humuzi"})
    public void updateExtendProperty(){

        Response response = given().accept("application/json")
                .header("entCode","EC1704131UT5KW00").header("tokenId",auth.adminLogin().getTokenId())
                .put("https://dev.maycur.com/api/web/ctrip/employee_extend_property");

        assertThat(response.getBody().asString(),response.getStatusCode(),equalTo(200));
        assertThat(response.getBody().asString(),response.getBody().jsonPath().get("code").equals("ACK"));
    }

    /**
     * 同步携程员工
     */
    @Test(groups = {"humuzi"})
    public void syncEmployee(){
        JSONObject jsonObject = new JSONObject().put("AppKey","obk_testnet")
                .put("Ticket","5cdbb442eb3f8a35000fe454")
                .put("CorporationID","testnet")
                .put("AuthenticationInfoList","[\n" +
                        "        {\n" +
                        "            \"Sequence\": 0,\n" +
                        "            \"Authentication\": {\n" +
                        "                \"EmployeeID\\\": \"426\",\n" +
                        "                \"Name\": \"小白\",\n" +
                        "                \"Email\": \"hu@163.com\",\n" +
                        "                \"Valid\": \"A\",\n" +
                        "                \"Dept2\": \"财务部门\",\n" +
                        "                \"SubAccountName\": \"Mango\",\n" +
                        "                \"UseTRFlag\": 28,\n" +
                        "                \"IsSendEMail\": true,\n" +
                        "                \"IsBookClass\": \"F\",\n" +
                        "                \"IntlBookClassBlock\": \"C;F\"\n" +
                        "            }\n" +
                        "        }\n" +
                        "    ]");

        Response response = given().accept("application/json")
                .header("entCode","EC1704131UT5KW00")
                .header("tokenId",auth.adminLogin().getTokenId())
                .body(jsonObject.toString()).post("https://dev.maycur.com/api/web/ctrip/syncEmployees");

        assertThat(response.getBody().asString(),response.getStatusCode(),equalTo(200));
    }

    /**
     * 更新携程配置
     */

    @Test(groups = {"humuzi"})
    public void changeConfigure(){
        JSONObject jsonObject = new JSONObject().put("priceTypes","[]")
                .put("cityTypes","[]")
                .put("reconciliations","[1,2,4]")
                .put("notificationEmail",true)
                .put("restrictDomesticClass",true)
                .put("employeeProps","[\n" +
                        "{\n" +
                        "\"code\":\"subsidiary\",\n" +
                        "\"name\":\"业务实体名称\",\n" +
                        "\"selected\":true\n" +
                        "},\n" +
                        "{\n" +
                        "\"code\":\"department\",\n" +
                        "\"name\":\"部门名称\",\n" +
                        "\"selected\":true\n" +
                        "}\n" +
                        "]")
                .put("journeyProps","\"journeyProps\":[\n" +
                        "{\n" +
                        "\"code\":\"subsidiary\",\n" +
                        "\"name\":\"业务实体名称\",\n" +
                        "\"selected\":true\n" +
                        "}\n" +
                        "]")
                .put("extendJourneyDate",true)
                .put("forwardDays",2)
                .put("postponeDays",3)
                .put("empOrderTypes","[1,2]")
                .put("unifyReimbursePeriod",true)
                .put("settlementSettingBits",7)
                .put("unifyReimburseSettingBits",7)
                .put("restrictHotelAvgPrice",true)
                .put("restrictFlightSeatClass",true)
                .put("restrictFlightBookingCount",1)
                .put("restrictIntlClass",true)
                .put("bookForOthers",3)
                .put("restrictFlightPrice",false)
                .put("restrictHotelPrice",false)
                .put("restrictTrainPrice",false)
                .put("restrictFlightCity",false)
                .put("restrictHotelCity",false)
                .put("restrictTrainCity",false)
                .put("authorizeType",1);

        Response response = given().accept("application/json")
                .header("entCode","EC1704131UT5KW00")
                .header("tokenId",auth.adminLogin().getTokenId())
                .body(jsonObject.toString())
                .post("https://dev.maycur.com/api/web/ctrip/changeConfigurableAttr");

        assertThat(response.getBody().asString(),response.getStatusCode(),equalTo(200));
        assertThat(response.getBody().asString(),response.getBody().jsonPath().get("code"),equalTo("ACK"));
    }


}
