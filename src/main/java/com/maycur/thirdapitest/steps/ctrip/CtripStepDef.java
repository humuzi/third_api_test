package com.maycur.thirdapitest.steps.ctrip;


import com.maycur.thirdapitest.runtime.LoginUser;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.annotations.DataProvider;
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
//    LoginUser loginUser = new LoginUser();
//    @Autowired private LoginUser loginUser;
    AuthStepDef auth = new AuthStepDef();

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


}
