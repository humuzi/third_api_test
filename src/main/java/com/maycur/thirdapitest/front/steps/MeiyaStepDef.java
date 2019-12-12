package com.maycur.thirdapitest.front.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maycur.thirdapitest.common.runtime.LoginUser;
import com.maycur.thirdapitest.common.util.ConfigUtil;
import com.maycur.thirdapitest.front.dto.MeiyaConfigDto;
import com.maycur.thirdapitest.front.mapper.MeiyaEntInfoMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
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
public class MeiyaStepDef extends AbstractTestNGSpringContextTests {

    @Autowired private LoginUser loginUser;
    @Autowired private ConfigUtil configUtil;
    @Autowired private MeiyaEntInfoMapper meiyaEntInfoMapper;
    /**
     * 设置员工审批人
     */
    @Test(groups = {"xigua"})
    public void setApprover() {
        JSONObject jsonObject = new JSONObject().put("AO", "1")
                .put("AE", "2").put("AR", "2")
                .put("HO", "1").put("TO", "1");

        Response response = given().accept("application/json")
                .header("entCode", "EC1804101CWRZ5L1")
                .header("tokenId", loginUser.getTokenId())
                .body(jsonObject.toString())
                .post(configUtil.getBaseUrl() + "/meiya/approver/setting");

        assertThat(response.getBody().asString(),response.getStatusCode(),equalTo(200));
        assertThat(response.getBody().asString(),response.getBody().jsonPath().get("code"),equalTo("ACK"));
    }


    /**
     * 更新美亚设置
     */
    @Test(groups = {"xigua"})
    public void changeConfig() throws Throwable{
        String meiyaEntConfig = IOUtils.toString(new FileInputStream(configUtil.getTestDataPath() + "/meiyaConfig.json"),"UTF-8");

        Response response = given().accept("application/json").contentType(ContentType.JSON)
                .header("entCode","EC1804101CWRZ5L1")
                .header("tokenId",loginUser.getTokenId())
                .body(meiyaEntConfig)
                .post(configUtil.getBaseUrl() + "/meiya/changeConfigurableAttr");

        assertThat(response.getBody().asString(),response.getStatusCode(),equalTo(200));
        assertThat(response.getBody().asString(),response.getBody().jsonPath().get("code"),equalTo("ACK"));

        MeiyaConfigDto meiyaConfigDto = new ObjectMapper().readValue(meiyaEntConfig,MeiyaConfigDto.class);
        assertThat(meiyaConfigDto.getEmployeeContainsMobile(),equalTo(meiyaEntInfoMapper.getEntInfo("UI18040313768S1W").getEmployeeContainsMobile()));
        assertThat(meiyaConfigDto.getJourneyContainsSubsidiary(),equalTo(meiyaEntInfoMapper.getEntInfo("UI18040313768S1W").getJourneyContainsSubsidiary()));
        assertThat(meiyaConfigDto.getUnifyReimburseFlight(),equalTo(meiyaEntInfoMapper.getEntInfo("UI18040313768S1W").getUnifyReimFlight()));
    }

    /**
     * 同步员工至美亚
     */
    @Test(groups = {"xigua"})
    public void syncEmployee(){

        Response response = given().accept("application/json")
                .header("entCode","EC1804101CWRZ5L1")
                .header("tokenId",loginUser.getTokenId())
                .post(configUtil.getBaseUrl() + "/meiya/syncEmployees/");

        assertThat(response.getBody().asString(),response.getStatusCode(),equalTo(200));
        assertThat(response.getBody().asString(),response.getBody().jsonPath().get("code"),equalTo("ACK"));

    }

    /**
     * 同步审批人到美亚
     */
    @Test(groups = {"xigua"})
    public void syncApprover(){

        Response response  = given().accept("application/json")
                .header("entCode","EC1804101CWRZ5L1")
                .header("tokenId",loginUser.getTokenId())
                .post(configUtil.getBaseUrl() + "/meiya/syncApprover");
        assertThat(response.getBody().asString(),response.getStatusCode(),equalTo(200));
        assertThat(response.getBody().asString(),response.getBody().jsonPath().get("code"),equalTo("ACK"));

    }
}
