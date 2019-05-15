package com.maycur.thirdapitest.steps.auth;

import static io.restassured.RestAssured.*;

import com.maycur.thirdapitest.dto.AuthLoginDto;
import com.maycur.thirdapitest.runtime.LoginUser;
import io.restassured.http.ContentType;
import io.restassured.response.*;
import org.json.JSONObject;

import org.springframework.stereotype.Component;
import org.testng.annotations.*;



/**
 * Create by HuQiuYue on 2019-04-10
 */

@Component
public class AuthStepDef {

    LoginUser loginUser = new LoginUser();

    /**
     * 管理员登录
     * @return
     */

    @Test(groups = {"humuzi"})
    public LoginUser adminLogin() {

        JSONObject jsonObject = new JSONObject().put("userName", "18367148256").put("password", "123456");
        Response response = given().accept("application/json").contentType(ContentType.JSON)
                .body(jsonObject.toString())
                .post("https://dev.maycur.com/api/web/auth/login");

        response.print();
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);

        AuthLoginDto result = response.getBody().as(AuthLoginDto.class);
        loginUser.setUserCode(result.getData().getUserCode());
        loginUser.setTokenId(result.getData().getTokenId());
        loginUser.setRefreshTokenId(result.getData().getRefreshTokenId());

        return loginUser;
    }


}
