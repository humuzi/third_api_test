package com.maycur.thirdapitest.api.steps;

import com.maycur.thirdapitest.common.runtime.LoginUser;
import com.maycur.thirdapitest.common.util.ConfigUtil;
import com.maycur.thirdapitest.common.util.ExcelUtil;
import io.restassured.response.Response;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


/**
 * Create by HuQiuYue on 2019-11-01
 */
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class CtripSettlementBillStepDef extends AbstractTestNGSpringContextTests {
    @Autowired private ConfigUtil configUtil;
    @Autowired private ExcelUtil excelUtil;
    @Autowired private LoginUser loginUser;

    @Test(groups = {"xigua"})
    public void uploadBillFile() throws IOException {
        File billFile = new File(configUtil.getTestDataPath() + "/excel/携程账单模板文件.xlsx");
        Workbook workbook = WorkbookFactory.create(billFile);
        List<String> billData = excelUtil.ExcelToStrings(workbook,0,0);

        Response response = given().contentType("multipart/form-data").multiPart(billFile)
                .header("entCode","EC1705101O7ZQCCG")
                .header("tokenId",loginUser.getTokenId())
                .post(configUtil.getBaseUrl() + "/tmc/upload/ctrip-settlement-bill");

        assertThat(response.getStatusCode(),equalTo("200"));
        assertThat(response.getBody().jsonPath().get("code"),equalTo("ACK"));
    }





}
