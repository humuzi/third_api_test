package com.maycur.thirdapitest.api.steps;


import com.maycur.thirdapitest.api.dto.FanjiaReconcilingBillDetailsDto;
import com.maycur.thirdapitest.api.dto.FanjiaReconcilingBillsDto;
import com.maycur.thirdapitest.api.dto.FanjiaUnreconciledBillsDto;
import com.maycur.thirdapitest.api.dto.BillsDto;
import com.maycur.thirdapitest.api.mapper.FanjiaBillMapper;
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
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Create by HuQiuYue on 2019-11-05
 */
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class FanjiaBillStepDef extends AbstractTestNGSpringContextTests {
    @Autowired private ConfigUtil configUtil;
    @Autowired private LoginUser loginUser;
    @Autowired private FanjiaBillMapper fanjiaBillMapper;

    //根据业务实体获取已拉取账单
    @Test(groups = {"xigua"})
    public void getFetchedBills() throws Throwable{
        String billSubsidiaryCode = IOUtils.toString(new FileInputStream(configUtil.getTestDataPath() + "/fanjia/fanjiaBillParams.json"),"UTF-8");
        Response response = given().accept("application/json").contentType(ContentType.JSON)
                .header("entCode","EC180411X4F81TM")
                .header("tokenId",loginUser.getTokenId())
                .body(billSubsidiaryCode)
                .post(configUtil.getBaseUrl() + "/tmc/settlement-bill/get-unreconciled-tmc-bills");

        FanjiaUnreconciledBillsDto result = response.getBody().as(FanjiaUnreconciledBillsDto.class);
        List<BillsDto> list = result.getData();
        assertThat(String.valueOf(list.size()),equals(fanjiaBillMapper.getbillsNum("EC180411X4F81TM","RECONCILING")));
    }


//    拉取账单
    @Test(groups = {"xigua"})
    public void fetchBills(){
        Response response = given().accept("application/json")
                .header("entCode","EC180411X4F81TM")
                .header("tokenId",loginUser.getTokenId())
                .get(configUtil.getBaseUrl() + "/tmc/settlement-bill/refresh-new-bills/fanjia");

        assertThat(response.getBody().asString(),response.getStatusCode(),equalTo(200));
        assertThat(response.getBody().asString(),response.getBody().jsonPath().get("code"),equalTo("ACK"));
    }

//    选择账单发起对账
//    public String startBills(){
//
//    }

//    获取对账详情
    @Test(groups = {"xigua"})
    public void getReconcileDetails() throws Throwable{
        String billDetailParams = IOUtils.toString(new FileInputStream(configUtil.getTestDataPath() + "/fanjia/BilldetailsParam.json"),"UTF-8");
        Response response = given().accept("application/json").contentType(ContentType.JSON)
                .header("entCode","EC180411X4F81TM")
                .header("tokenId",loginUser.getTokenId())
                .body(billDetailParams).post(configUtil.getBaseUrl() + "/tmc/settlement-bill/reconcile-details");

        FanjiaReconcilingBillsDto reconcilingBillsDto = response.getBody().as(FanjiaReconcilingBillsDto.class);

        assertThat(reconcilingBillsDto.getData().get(0).getReconResult(),equalTo("SUCCESS"));
        List<FanjiaReconcilingBillDetailsDto> result = reconcilingBillsDto.getData();
        assertThat(String.valueOf(result.size()),equalTo(fanjiaBillMapper.getBillDetailsNum("EC180411X4F81TM","TMCRB180928Z411VUO")));

    }


}
