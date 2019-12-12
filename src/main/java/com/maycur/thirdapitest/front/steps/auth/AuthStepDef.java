package com.maycur.thirdapitest.front.steps.auth;

import com.maycur.thirdapitest.front.dto.AuthLoginDto;
import com.maycur.thirdapitest.common.runtime.LoginUser;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;



/**
 * Create by HuQiuYue on 2019-04-10
 */

@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class AuthStepDef extends AbstractTestNGSpringContextTests{

    @Autowired
    private LoginUser loginUser;


    @Test(groups = {"muzi"})
    public void loginWeb() {

        JSONObject jsonObject = new JSONObject().put("userName", "18367148256").put("password", "123456").put("lang","zh");
        Response response = given().contentType(ContentType.JSON).accept("application/json")
                .body(jsonObject.toString())
                .post("https://dev.maycur.com/api/web/auth/login");

        AuthLoginDto result = response.getBody().as(AuthLoginDto.class);
        loginUser.setUserCode(result.getData().getUserCode());
        loginUser.setTokenId(result.getData().getTokenId());
        loginUser.setRefreshTokenId(result.getData().getRefreshTokenId());
        loginUser.setEntCode(result.getData().getEnts().get(0).getEntCode());
        loginUser.setUserName(result.getData().getUserName());

        System.out.println(loginUser);

    }


}
