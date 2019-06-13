package com.maycur.thirdapitest.util;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import static io.restassured.RestAssured.given;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * Create by HuQiuYue on 2019-06-12
 */
public class DidiApiUtil {

    public static final Logger logger = LoggerFactory.getLogger(DidiApiUtil.class);

    public String getSign(){

        String sign = "";
        Map<String,Object> params = new TreeMap<>();

        //添加sign key
        params.put("sign_key", "5929E39841cc6353badf");

        //遍历获取key和value
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            if (!StringUtils.isEmpty(sign)) {
                sign += "&";
            }
            sign += entry.getKey() + "=" + entry.getValue();
        }

        params.remove("sign_key");
        logger.info("sign param str :" + sign);

        //返回md5加密
        return MD5Util.string2MD5WithCharSet(sign, "utf-8");

    }


    public String getAccessToken(){
        JSONObject jsonObject = new JSONObject()
                .put("client_id","hzmkkj")
                .put("client_secret","")
                .put("grant_type","client_credentials")
                .put("phone","13081000101")
                .put("timestamp",String.valueOf(System.currentTimeMillis()))
                .put("sign",getSign());

        Response response = given().accept("application/json")
                .body(jsonObject.toString())
                .post("http://30.40.80.12:6500/river/Auth/authorize");

        return response.getBody().jsonPath().get("access_token");

    }

}
