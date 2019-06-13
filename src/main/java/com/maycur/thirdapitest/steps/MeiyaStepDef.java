package com.maycur.thirdapitest.steps;

import com.maycur.thirdapitest.steps.auth.AuthStepDef;
import com.maycur.thirdapitest.util.ConfigUtil;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.FileInputStream;

/**
 * Create by HuQiuYue on 2019-05-28
 */
public class MeiyaStepDef {

    AuthStepDef auth = new AuthStepDef();
    ConfigUtil configUtil = new ConfigUtil();

    /**
     * 设置员工审批人
     */
    @Test(groups = {"humuzi"})
    public void setApprover() {
        JSONObject jsonObject = new JSONObject().put("AO", "1")
                .put("AE", "2").put("AR", "2")
                .put("HO", "1").put("TO", "1");

        Response response = given().accept("application/json")
                .header("entCode", "EC1804101CWRZ5L1")
                .header("tokenId", auth.adminLogin().getTokenId())
                .body(jsonObject.toString())
                .post(configUtil.getBaseUrl() + "/meiya/approver/setting");

        assertThat(response.getBody().asString(),response.getStatusCode(),equalTo(200));
        assertThat(response.getBody().asString(),response.getBody().jsonPath().get("code"),equalTo("ACK"));
    }


    /**
     * 更新美亚设置
     */
    @Test(groups = {"humuzi"})
    public void changeConfig() throws Throwable{
        String jsonObject = IOUtils.toString(new FileInputStream(configUtil.getTestDataPath() + "/meiyaConfig.json"),"UTF-8");

        Response response = given().accept("application/json").contentType(ContentType.JSON)
                .header("entCode","EC1804101CWRZ5L1")
                .header("tokenId",auth.adminLogin().getTokenId())
                .body(jsonObject)
                .post(configUtil.getBaseUrl() + "/meiya/changeConfigurableAttr");

        assertThat(response.getBody().asString(),response.getStatusCode(),equalTo(200));
        assertThat(response.getBody().asString(),response.getBody().jsonPath().get("code"),equalTo("ACK"));
    }

    /**
     * 同步员工至美亚
     */
    public void syncEmployee(){

    }
}
