package com.maycur.thirdapitest.util;

import io.restassured.response.Response;
import org.json.JSONObject;
import static io.restassured.RestAssured.given;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;


/**
 * Create by HuQiuYue on 2019-06-20
 */
public class MeiyaSessionIdUtil {
    public String getSessionId(){
        PasswordUtil passwordUtil = new PasswordUtil();
        JSONObject jsonObject = new JSONObject()
                .put("password",passwordUtil.generatePassword("S117582","4f3f29eb05ee4cda81528647e91608d4","","10010",
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(System.currentTimeMillis()).replaceAll("[[\\s-:punct:]]","")))
                .put("passwordType","0")
                .put("companyId","S117582")
                .put("timeStamp",System.currentTimeMillis()/1000);

        Response response = given().accept("application/json")
                .body(jsonObject.toString())
                .post(" http://121.41.36.97:6005/API.svc/Login");

        return response.getBody().jsonPath().get("sessionId");
    }


}
