package com.maycur.thirdapitest.util;

import com.maycur.thirdapitest.api.mapper.CtripEntInfo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;


import static io.restassured.RestAssured.given;
/**
 * Create by HuQiuYue on 2019-09-05
 */
public class CtripTokenUtil {

    @Autowired private CtripEntInfo ctripEntInfo;

    /**
     * 获取携程Token
     */
    public String getCtripToken(String entCode){
        JSONObject body = new JSONObject().put("appKey",ctripEntInfo.selectEntInfo(entCode).getAppKey())
                .put("appSecurity",ctripEntInfo.selectEntInfo(entCode).getAppSecurity());
        Response response = given().accept("application/json").contentType(ContentType.JSON)
                .body(body)
                .post("https://ct.ctrip.com/SwitchAPI/Order/Ticket");

        return response.getBody().jsonPath().get("Ticket").toString();
    }
}
