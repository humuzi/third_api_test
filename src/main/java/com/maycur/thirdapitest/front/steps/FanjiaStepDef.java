package com.maycur.thirdapitest.front.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maycur.thirdapitest.common.runtime.LoginUser;
import com.maycur.thirdapitest.common.util.ConfigUtil;
import com.maycur.thirdapitest.front.mapper.FanjiaEntInfoMapper;
import com.maycur.thirdapitest.front.pojo.FanjiaEntInfo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.io.FileInputStream;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Create by HuQiuYue on 2019-05-28
 */
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class FanjiaStepDef extends AbstractTestNGSpringContextTests {
    @Autowired private LoginUser loginUser;
    @Autowired private ConfigUtil configUtil;
    @Autowired private FanjiaEntInfoMapper fanjiaEntInfoMapper;

    /**
     * 更新泛嘉管理页配置
     */
    @Test(groups = {"xigua"})
    public void updateConfig() throws Throwable{

        String jsonObject = IOUtils.toString(new FileInputStream(configUtil.getTestDataPath() + "/fanjia/fanjiaConfig.json"),"UTF-8");
        Response response = given().accept("application/json").contentType(ContentType.JSON)
                .header("entCode","EC180411X4F81TM")
                .header("tokenId",loginUser.getTokenId())
                .body(jsonObject)
                .post(configUtil.getBaseUrl() + "/fanjia/changeConfigurableAttr");

        assertThat(response.getBody().asString(),response.getStatusCode(),equalTo(200));
        assertThat(response.getBody().asString(),response.getBody().jsonPath().get("code"),equalTo("ACK"));

        FanjiaEntInfo entInfo = new ObjectMapper().readValue(jsonObject,FanjiaEntInfo.class);
        assertThat(entInfo.getHoursPriceControlMode(),equalTo(fanjiaEntInfoMapper.getEntConfig("EC180411X4F81TM").getHoursPriceControlMode()));
        assertThat(entInfo.getHotelCityControlMode(),equalTo(fanjiaEntInfoMapper.getEntConfig("EC180411X4F81TM").getHotelCityControlMode()));

    }

    /**
     * 泛嘉同步员工
     */
    @Test(groups = {"xigua"})
    public void syncEmployee(){

        Response response = given().accept("application/json").contentType(ContentType.JSON)
                .header("entCode","EC180411X4F81TM")
                .header("tokenId",loginUser.getTokenId())
                .post(configUtil.getBaseUrl() + "/fanjia/sync/employees");

        assertThat(response.getBody().toString(),response.getStatusCode(),equalTo(200));
        assertThat(response.getBody().toString(),response.getBody().jsonPath().get("code"),equalTo("ACK"));
    }
}
