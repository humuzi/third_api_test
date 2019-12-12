package com.maycur.thirdapitest.mobile.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maycur.thirdapitest.common.constant.Constant;
import com.maycur.thirdapitest.common.util.ConfigUtil;
import com.maycur.thirdapitest.mobile.dto.CtripFromTravelManageDto;
import com.maycur.thirdapitest.mobile.dto.CtripLoginFromHomeDto;
import com.maycur.thirdapitest.mobile.pojo.CtripGetTokenResult;
import com.maycur.thirdapitest.mobile.pojo.CtripLoginFromHomeInfo;
import com.maycur.thirdapitest.mobile.pojo.LoginUser;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.io.IOUtils;
import org.hamcrest.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.io.FileInputStream;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Create by HuQiuYue on 2019-11-26
 */
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class CtripStepDef extends AbstractTestNGSpringContextTests {
    @Autowired private LoginUser loginUser;
    @Autowired private ConfigUtil configUtil;
    @Autowired private CtripGetTokenResult ctripGetTokenResult;

//    获取单点登录token(首页)
    @Test(groups = {"muzi"})
    public void loginFromHomeToken(){
        Response token = given().accept("application/json")
                .header("entCode","EC16051712MRTHC0").header("tokenId",loginUser.getTokenId())
                .post(configUtil.getMobileBaseUrl() + Constant.CTRIP_TOKEN_URL);
        CtripLoginFromHomeDto result = token.getBody().as(CtripLoginFromHomeDto.class);
        ctripGetTokenResult.setAppId(result.getData().getAppId());
        ctripGetTokenResult.setAppKey(result.getData().getAppKey());
        ctripGetTokenResult.setToken(result.getData().getToken());
    }

    public void loginFromTravelManageToken() throws Throwable{
        String tokenParams = IOUtils.toString(new FileInputStream(configUtil.getTestDataPath() + "/mobile/ctripGetTokenParam.json"),"UTF-8");

        Response fromTravelRecord = given().accept("application/json").contentType(ContentType.JSON)
                .header("entCode","EC16051712MRTHC0").header("tokenId",loginUser.getTokenId())
                .body(tokenParams).post(configUtil.getMobileBaseUrl() + Constant.CTRIP_TOKEN_URL);

        CtripFromTravelManageDto result = fromTravelRecord.getBody().as(CtripFromTravelManageDto.class);



    }

//    申请单入口
    public void getLoginFromPreConsume(){}

//    行程管理入口
    public void getLoginFromTravelManage(){

    }

//    首页飞机登录
    @Test(groups = {"muzi"},dependsOnMethods = {"loginFromHomeToken"})
    public void getLoginFromHome() throws Throwable{

        String params = IOUtils.toString(new FileInputStream(configUtil.getTestDataPath() + "/mobile/ctripLoginParam.json"),"UTF-8");
        CtripLoginFromHomeInfo ctripLoginFromHomeInfo = new ObjectMapper().readValue(params,CtripLoginFromHomeInfo.class);
        ctripLoginFromHomeInfo.setToken(ctripGetTokenResult.getToken());

        Response fromHome = given().accept("application/json").contentType(ContentType.JSON)
                .header("entCode","").header("tokenId",loginUser.getTokenId())
                .body(params).post(Constant.CTRIP_H5_LOGIN_URL);

        assertThat(fromHome.getStatusCode(), Matchers.equalTo(200));
    }


}


