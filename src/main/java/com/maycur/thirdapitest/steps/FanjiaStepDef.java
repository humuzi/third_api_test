package com.maycur.thirdapitest.steps;

import com.maycur.thirdapitest.runtime.LoginUser;
import com.maycur.thirdapitest.util.ConfigUtil;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.io.IOUtils;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import java.io.FileInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * Create by HuQiuYue on 2019-05-28
 */
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class FanjiaStepDef extends AbstractTestNGSpringContextTests {
    @Autowired private LoginUser loginUser;
    @Autowired private ConfigUtil configUtil;

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
    }

    /**
     * 泛嘉同步员工
     */
    @Test(groups = {"xigua"})
    public void syncEmployee() throws Throwable{

        String jsonObject = IOUtils.toString(new FileInputStream(configUtil.getTestDataPath() + "/fanjia/syncEmployee.json"),"UTF-8");
        Response response = given().accept("application/json").contentType(ContentType.JSON)
                .header("entCode","EC180411X4F81TM")
                .header("tokenId",loginUser.getTokenId())
                .body(jsonObject)
                .post(configUtil.getBaseUrl() + "/fanjia/sync/employees");

        assertThat(response.getBody().toString(),response.getStatusCode(),equalTo(200));
        assertThat(response.getBody().toString(),response.getBody().jsonPath().get("code"),equalTo("ACK"));
    }
}
