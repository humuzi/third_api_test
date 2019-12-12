package com.maycur.thirdapitest.front.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maycur.thirdapitest.common.runtime.LoginUser;
import com.maycur.thirdapitest.front.mapper.CtripEntInfoMapper;
import com.maycur.thirdapitest.front.pojo.CtripEntInfo;
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
 * Create by HuQiuYue on 2019-05-07
 */
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class CtripStepDef extends AbstractTestNGSpringContextTests {

    @Autowired
    private LoginUser loginUser;
    @Autowired private CtripEntInfoMapper ctripEntInfoMapper;

    /**
     * 设置subAccount例外人员
     */
    @Test(groups = {"muzi"})
    public void setSubAccountException() throws Throwable{
        String unificationEmployees = IOUtils.toString(new FileInputStream("src/main/resources/testdata/ctrip/SAException.json"),"UTF-8");

        Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
                .header("entCode","EC1704131UT5KW00")
                .header("tokenId",loginUser.getTokenId())
                .body(unificationEmployees)
                .post("https://dev.maycur.com/api/web/ctrip/exception_member/SUB_ACCOUNT_UNIFICATION");

        assertThat(response.getBody().asString(),response.getStatusCode(),equalTo(200));
        assertThat(response.getBody().asString(),response.getBody().jsonPath().get("code"),equalTo("ACK"));
    }


    /**
     * 设置授权人例外人员
     */
    @Test(groups = {"xigua"})
    public void setConfirmPersonException() throws Throwable{

        String jsonObject = IOUtils.toString(new FileInputStream("src/main/resources/testdata/ctrip/confirmPersonException.json"),"UTF-8");
        Response response = given().contentType(ContentType.JSON)
                .header("entCode","EC1704131UT5KW00")
                .header("tokenId",loginUser.getTokenId())
                .body(jsonObject)
                .post("https://dev.maycur.com/api/web/ctrip/exception_member/CONFIRM_PERSON_UNIFICATION");

        assertThat(response.getBody().asString(),response.getStatusCode(),equalTo(200));
        assertThat(response.getBody().asString(),response.getBody().jsonPath().get("code"),equalTo("ACK"));
    }

    /**
     * 保存规则设置
     */
    @Test(groups = {"xigua"})
    public void saveRuleSetting() throws Throwable{

        String jsonObject = IOUtils.toString(new FileInputStream("src/main/resources/testdata/ctrip/ruleSetting.json"),"UTF-8");
        Response response = given().accept("application/json").contentType(ContentType.JSON)
                .header("entCode","EC1704131UT5KW00")
                .header("tokenId",loginUser.getTokenId())
                .body(jsonObject)
                .put("https://dev.maycur.com/api/web/ctrip/unification_switch");

        assertThat(response.getBody().asString(),response.getStatusCode(),equalTo(200));
        assertThat(response.getBody().asString(),response.getBody().jsonPath().get("code"),equalTo("ACK"));

    }

    /**
     * 更新携程员工Extend_property
     */

    @Test(groups = {"xigua"})
    public void updateExtendProperty(){

        Response response = given().accept("application/json")
                .header("entCode","EC1704131UT5KW00")
                .header("tokenId",loginUser.getTokenId())
                .put("https://dev.maycur.com/api/web/ctrip/employee_extend_property");

        assertThat(response.getBody().asString(),response.getStatusCode(),equalTo(200));
        assertThat(response.getBody().asString(),response.getBody().jsonPath().get("code").equals("ACK"));
    }

    /**
     * 同步携程员工
     */
    @Test(groups = {"xigua"})
    public void syncEmployee(){

        Response response = given().accept("application/json").contentType(ContentType.JSON)
                .header("entCode","EC1704131UT5KW00")
                .header("tokenId",loginUser.getTokenId())
                .post("https://dev.maycur.com/api/web/ctrip/syncEmployees");

        assertThat(response.getBody().asString(),response.getStatusCode(),equalTo(200));
    }

    /**
     * 更新携程配置
     */

    @Test(groups = {"xigua"})
    public void changeConfigure() throws Throwable {

        String jsonObject = IOUtils.toString(new FileInputStream("src/main/resources/testdata/ctrip/ctripSetting.json"),"UTF-8");

        Response response = given().accept("application/json").contentType(ContentType.JSON)
                .header("entCode","EC1704131UT5KW00")
                .header("tokenId",loginUser.getTokenId())
                .body(jsonObject)
                .post("https://dev.maycur.com/api/web/ctrip/changeConfigurableAttr");

        assertThat(response.getBody().asString(),response.getStatusCode(),equalTo(200));
        assertThat(response.getBody().asString(),response.getBody().jsonPath().get("code"),equalTo("ACK"));

        CtripEntInfo entInfo = new ObjectMapper().readValue(jsonObject,CtripEntInfo.class);
        assertThat(entInfo.getAuthorizeType(),equalTo(ctripEntInfoMapper.getEntInfo("EC1705101O7ZQCCG").getAuthorizeType()));
        assertThat(entInfo.getHotelAgreementServiceFee(),equalTo(ctripEntInfoMapper.getEntInfo("EC1705101O7ZQCCG").getHotelAgreementServiceFee()));
    }

}
