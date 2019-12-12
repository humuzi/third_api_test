package com.maycur.thirdapitest.api.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maycur.thirdapitest.api.dto.MeiyaBillParamDto;
import com.maycur.thirdapitest.api.mapper.MeiyaBillMapper;
import com.maycur.thirdapitest.common.runtime.LoginUser;
import com.maycur.thirdapitest.common.util.ConfigUtil;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Create by HuQiuYue on 2019-11-08
 */
@ContextConfiguration(locations = {"classpath:"})
public class MeiyaBillStepDef extends AbstractTestNGSpringContextTests {
    @Autowired private ConfigUtil configUtil;
    @Autowired private MeiyaBillMapper meiyaBillMapper;
    @Autowired private LoginUser loginUser;

    @Test(groups = {"xigua"})
    public void fetchMeiyaBill() throws Throwable{
        String billParams = IOUtils.toString(new FileInputStream(configUtil.getTestDataPath() + "/meiya/meiyaBillParam.json"),"UTF-8");
        MeiyaBillParamDto billParamDto = new ObjectMapper().readValue(billParams,MeiyaBillParamDto.class);
        billParamDto.setBillFileName("账单" + System.currentTimeMillis());

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(meiyaBillMapper.getLastBillEndDate("EC1804101CWRZ5L1"));
        calendar.add(Calendar.DATE,+1);
        billParamDto.setStartDate(String.format(String.valueOf(calendar.getTime()), "yyyy-MM-dd"));

        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(meiyaBillMapper.getLastBillEndDate("EC1804101CWRZ5L1"));
        calendar1.add(Calendar.MONTH,+1);
        billParamDto.setEndDate(String.format(String.valueOf(calendar1.getTime()),"yyyy-MM-dd"));

        Response response = given().accept("application/json").contentType(ContentType.JSON)
                .header("entCode","EC1804101CWRZ5L1")
                .header("tokenId",loginUser.getTokenId())
                .body(billParams).post(configUtil.getBaseUrl() + "/tmc/settlement-bill/refresh-new-bills-with-criteria/meiya");

        assertThat(response.getBody().asString(),response.getStatusCode(),equalTo(200));
        assertThat(response.getBody().asString(),response.getBody().jsonPath().get("code"),equalTo("ACK"));
    }
}
