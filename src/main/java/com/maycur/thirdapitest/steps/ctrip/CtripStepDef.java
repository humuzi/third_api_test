package com.maycur.thirdapitest.steps.ctrip;

import com.maycur.thirdapitest.runtime.LoginUser;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import com.maycur.thirdapitest.steps.auth.*;


/**
 * Create by HuQiuYue on 2019-05-07
 */
public class CtripStepDef {
    LoginUser loginUser = new LoginUser();

    /**
     * 更新携程员工Extend_property
     */

    @Test(groups = {"humuzi"})
    public void updateExtendProperty(){

        Response response = given().accept("application/json")
                .header("entCode","EC1704131UT5KW00").header("tokenId",loginUser.getTokenId())
                .put("https://dev.maycur.com/api/web/ctrip/employee_extend_property");

        assertThat(response.getBody().asString(),response.getStatusCode(),equalTo(200));
        assertThat(response.getBody().asString(),response.getBody().jsonPath().get("code").equals("ACK"));
    }
}
