//package com.maycur.thirdapitest.steps;
//
//import com.maycur.thirdapitest.steps.auth.AuthStepDef;
//import com.maycur.thirdapitest.util.ConfigUtil;
//import io.restassured.response.Response;
//import org.json.JSONObject;
//import org.testng.annotations.Test;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.equalTo;
//import static io.restassured.RestAssured.given;
//
///**
// * Create by HuQiuYue on 2019-06-12
// */
//public class DidiStepDef {
//    ConfigUtil configUtil = new ConfigUtil();
//    AuthStepDef authStepDef = new AuthStepDef();
//
//
//
//    /**
//     * 单个员工绑定
//     */
////    @Test(groups = {"humuzi"})
////    public void bindMember(){
////        JSONObject jsonObject = new JSONObject()
////                .put("phone","18367148256")
////                .put("captcha",generateCaptcha());
////
////        Response response = given().accept("application/json")
////                .body(jsonObject.toString())
////                .post(configUtil.getBaseUrl() + "/didi/user/bind");
////
////        assertThat(response.getBody().asString(),response.getBody().jsonPath().get("code"),equalTo("ACK"));
////        assertThat(response.getBody().asString(),response.getStatusCode(),equalTo(200));
////    }
//
//    /**
//     * 员工解绑
//     */
//    public void unbindMember(){
//        Response response = given().accept("application/json")
//                .header("entCode","EC16051712MRTHC0")
//                .header("tokenId",authStepDef.adminLogin().getTokenId())
//                .post(configUtil.getBaseUrl() + "/didi/user/unbind");
//
//        assertThat(response.getBody().asString(),response.getStatusCode(),equalTo(200));
//        assertThat(response.getBody().asString(),response.getBody().jsonPath().get("code"),equalTo("ACK"));
//    }
//
//
//    /**
//     * 更新管理配置
//     */
//
//    public void updateConfig(){}
//
//
//}
