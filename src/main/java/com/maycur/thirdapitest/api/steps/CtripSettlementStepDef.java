package com.maycur.thirdapitest.api.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maycur.thirdapitest.api.dto.CtripFlightSettlementInfoDto;
import com.maycur.thirdapitest.api.dto.FlightOrderAccountSettlementListDto;
import com.maycur.thirdapitest.api.dto.FlightSettlementResultDto;
import com.maycur.thirdapitest.api.dto.ctripSettlementParamDto.CtripSettlementParamDto;
import com.maycur.thirdapitest.api.mapper.CtripFlightOrderInfoMapper;
import com.maycur.thirdapitest.api.pojo.OrderInfo;
import com.maycur.thirdapitest.util.ConfigUtil;
import com.maycur.thirdapitest.util.CtripTokenUtil;
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
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Create by HuQiuYue on 2019-10-18
 */
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class CtripSettlementStepDef extends AbstractTestNGSpringContextTests {
    @Autowired private ConfigUtil configUtil;
    @Autowired private CtripTokenUtil ctripTokenUtil;
    @Autowired private CtripFlightOrderInfoMapper ctripFlightOrderInfoMapper;

    @Test(groups = {"muzi"})
    public void getFlightSettlementInfo() throws Throwable{
        String  body  = IOUtils.toString(new FileInputStream(configUtil.getTestDataPath() + "/ctrip/flightSettlementParam.json"),"UTF-8");
        CtripSettlementParamDto flightParamJson = new ObjectMapper().readValue(body,CtripSettlementParamDto.class);
        flightParamJson.getAuth().setTicket(ctripTokenUtil.getCtripToken());

        Response response = given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .body(body)
                .post("https://ct.ctrip.com/switchapi/FlightOrderSettlement/GetCorpAccountFlightOrderSettlements?type=json");

        List<FlightOrderAccountSettlementListDto> flightSettlementInfo = response.getBody().as(CtripFlightSettlementInfoDto.class).getFlightOrderAccountSettlementList();
        FlightSettlementResultDto expected = new FlightSettlementResultDto();
        expected.setRecordId(flightSettlementInfo.get(0).getOrderSettlementList().get(0).getOrderSettlementBaseInfo().getRecordID());
        expected.setOrderId(flightSettlementInfo.get(0).getOrderSettlementList().get(0).getOrderSettlementBaseInfo().getOrderID());
        expected.setAmount(flightSettlementInfo.get(0).getOrderSettlementList().get(0).getOrderSettlementBaseInfo().getAmount());
        expected.setItineraryFee(flightSettlementInfo.get(0).getOrderSettlementList().get(0).getOrderSettlementBaseInfo().getItineraryFee());
        expected.setPostServiceFee(flightSettlementInfo.get(0).getOrderSettlementList().get(0).getOrderSettlementBaseInfo().getPostServiceFee());
        expected.setJourneyNo(flightSettlementInfo.get(0).getOrderSettlementList().get(0).getOrderBaseInfo().getJourneyID());

        OrderInfo actual = ctripFlightOrderInfoMapper.getFlightSettlementInfo("EC1705101O7ZQCCG","73867628");
        assertThat(actual.getRecordId(),equalTo(expected.getRecordId()));
        assertThat(actual.getOrderId(),equalTo(expected.getOrderId()));
        assertThat(actual.getConsumeAmount(),equalTo(expected.getAmount()));
        assertThat(actual.getItineraryFee(),equalTo(expected.getItineraryFee()));
        assertThat(actual.getPostAmount(),equalTo(expected.getPostServiceFee()));
        assertThat(actual.getJourneyNo(),equalTo(expected.getJourneyNo()));
    }


}
