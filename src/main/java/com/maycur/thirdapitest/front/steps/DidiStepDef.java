package com.maycur.thirdapitest.front.steps;

import com.maycur.thirdapitest.common.runtime.LoginUser;
import com.maycur.thirdapitest.common.util.ConfigUtil;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

/**
 * Create by HuQiuYue on 2019-06-12
 */
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class DidiStepDef extends AbstractTestNGSpringContextTests {
   @Autowired private LoginUser loginUser;
   @Autowired private ConfigUtil configUtil;



    /**
     * 单个员工绑定
     */
//    @Test(groups = {"humuzi"})
//    public void bindMember(){
//        JSONObject jsonObject = new JSONObject()
//                .put("phone","18367148256")
//                .put("captcha",generateCaptcha());
//
//        Response response = given().accept("application/json")
//                .body(jsonObject.toString())
//                .post(configUtil.getBaseUrl() + "/didi/user/bind");
//
//        assertThat(response.getBody().asString(),response.getBody().jsonPath().get("code"),equalTo("ACK"));
//        assertThat(response.getBody().asString(),response.getStatusCode(),equalTo(200));
//    }

    /**
     * 员工解绑
     */
    public void unbindMember(){
        Response response = given().accept("application/json")
                .header("entCode","EC16051712MRTHC0")
                .header("tokenId",loginUser.getTokenId())
                .post(configUtil.getBaseUrl() + "/didi/user/unbind");

        assertThat(response.getBody().asString(),response.getStatusCode(),equalTo(200));
        assertThat(response.getBody().asString(),response.getBody().jsonPath().get("code"),equalTo("ACK"));
    }


    /**
     * 更新管理配置
     */

    public void updateConfig(){}


}
