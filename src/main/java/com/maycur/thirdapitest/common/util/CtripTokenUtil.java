package com.maycur.thirdapitest.common.util;

import com.maycur.thirdapitest.api.mapper.CtripEntInfoMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
/**
 * Create by HuQiuYue on 2019-09-05
 */
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class CtripTokenUtil extends AbstractTestNGSpringContextTests {

    @Autowired private CtripEntInfoMapper ctripEntInfoMapper;

    /**
     * 获取携程Token
     */
    @Test(groups = {"muzi"})
    public String getCtripToken(){
        JSONObject body = new JSONObject().put("appKey",ctripEntInfoMapper.selectEntInfo("EC1704201C9VD0QO").getAppKey())
                .put("appSecurity",ctripEntInfoMapper.selectEntInfo("EC1704201C9VD0QO").getAppSecurity());
        Response response = given().accept("application/json")
                .contentType(ContentType.JSON)
                .body(body.toString())
                .post("https://ct.ctrip.com/SwitchAPI/Order/Ticket");

        System.out.println(response.getBody().toString());
        return response.getBody().jsonPath().get("Ticket").toString();
    }
}
