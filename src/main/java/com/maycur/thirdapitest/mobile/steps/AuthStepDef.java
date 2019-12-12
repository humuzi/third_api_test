package com.maycur.thirdapitest.mobile.steps;

import com.maycur.thirdapitest.common.constant.Constant;
import com.maycur.thirdapitest.common.util.ConfigUtil;
import com.maycur.thirdapitest.mobile.dto.AuthLoginDto;
import com.maycur.thirdapitest.mobile.pojo.LoginUser;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileInputStream;

import static io.restassured.RestAssured.given;

/**
 * Create by HuQiuYue on 2019-11-28
 */
public class AuthStepDef {

    @Autowired private ConfigUtil configUtil;
    @Autowired private LoginUser loginUser;

    public void loginAPP() throws Throwable{
        String loginParam = IOUtils.toString(new FileInputStream(configUtil.getTestDataPath() + "/mobile/loginParam.json"),"UTF-8");
        Response login = given().accept("application/json").contentType(ContentType.JSON)
                .body(loginParam)
                .post(configUtil.getMobileBaseUrl() + Constant.MOBILE_LOGIN_URL);


        AuthLoginDto auth = login.getBody().as(AuthLoginDto.class);
        loginUser.setUserCode(auth.getData().getUserCode());
        loginUser.setTokenId(auth.getData().getTokenId());
        loginUser.setRefreshTokenId(auth.getData().getRefreshTokenId());
    }
}
