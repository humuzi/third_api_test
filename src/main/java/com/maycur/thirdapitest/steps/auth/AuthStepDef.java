package com.maycur.thirdapitest.steps.auth;

import static io.restassured.RestAssured.*;

import com.maycur.thirdapitest.dto.AuthLoginDto;
import com.maycur.thirdapitest.runtime.LoginUser;
import io.restassured.http.ContentType;
import io.restassured.response.*;
import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.*;



/**
 * Create by HuQiuYue on 2019-04-10
 */


public class AuthStepDef {

//    LoginUser loginUser = new LoginUser();

    @Autowired
    private LoginUser loginUser;

    /**
     * 管理员登录
     * @return
     */


    @Test(groups = {"muzi"})
    public void adminLogin() {

        JSONObject jsonObject = new JSONObject().put("userName", "18367148256").put("password", "123456").put("lang","zh");
        Response response = given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .body(jsonObject.toString())
                .post("https://dev.maycur.com/api/web/auth/login");


        AuthLoginDto result = response.getBody().as(AuthLoginDto.class);
        loginUser.setUserCode(result.getData().getUserCode());
        loginUser.setTokenId(result.getData().getTokenId());
        loginUser.setRefreshTokenId(result.getData().getRefreshTokenId());
        loginUser.setEntCode(result.getData().getEnts().get(0).getEntCode());
        loginUser.setUserName(result.getData().getUserName());

        System.out.println(loginUser.getTokenId());

    }


}
