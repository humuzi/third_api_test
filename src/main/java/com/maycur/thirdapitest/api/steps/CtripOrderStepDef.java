package com.maycur.thirdapitest.api.steps;

import com.alibaba.fastjson.JSON;
import com.maycur.thirdapitest.api.dto.CtripOrderInfoDto;
import com.maycur.thirdapitest.api.dto.FlightOrderResultDto;
import com.maycur.thirdapitest.api.dto.HotelOrderResultDto;
import com.maycur.thirdapitest.api.dto.ItineraryListDto;
import com.maycur.thirdapitest.api.dto.ctripOrderParamDto.CtripOrderParamDto;
import com.maycur.thirdapitest.api.mapper.CtripFlightOrderInfoMapper;
import com.maycur.thirdapitest.api.mapper.CtripHotelOrderInfoMapper;
import com.maycur.thirdapitest.api.pojo.OrderInfo;
import com.maycur.thirdapitest.util.ConfigUtil;
import com.maycur.thirdapitest.util.CtripTokenUtil;
import io.restassured.http.ContentType;
import com.fasterxml.jackson.databind.ObjectMapper;
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
 * Create by HuQiuYue on 2019-09-17
 */
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class CtripOrderStepDef extends AbstractTestNGSpringContextTests {
    @Autowired private CtripFlightOrderInfoMapper ctripFlightOrderInfoMapper;
    @Autowired private CtripHotelOrderInfoMapper ctripHotelOrderInfoMapper;
    @Autowired private ConfigUtil configUtil;
    @Autowired private CtripTokenUtil ctripTokenUtil;

    /**
     * 查询携程机票订单订单接口
     */

    @Test(groups = {"muzi"})
    public void searchFlightOrder() throws Throwable {

        String body = IOUtils.toString(new FileInputStream(configUtil.getTestDataPath()+"/ctrip/flightOrderParam.json"),"UTF-8");
        CtripOrderParamDto flightJson = new ObjectMapper().readValue(body,CtripOrderParamDto.class);
        flightJson.getRequest().getAuth().setTicket(ctripTokenUtil.getCtripToken());
        String flightOrderJson  = JSON.toJSONString(flightJson);

        Response response = given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .body(flightOrderJson)
                .post("https://ct.ctrip.com/switchapi/Order/SearchOrder");

        List<ItineraryListDto> flightInfo = response.getBody().as(CtripOrderInfoDto.class).getItineraryList();
        FlightOrderResultDto expected = new FlightOrderResultDto();
        expected.setOrderId(flightInfo.get(0).getFlightOrderInfoList().get(0).getBasicInfo().getOrderID());
        expected.setJourneyNo(flightInfo.get(0).getFlightOrderInfoList().get(0).getBasicInfo().getJourneyID());
        expected.setItineraryFee(flightInfo.get(0).getFlightOrderInfoList().get(0).getBasicInfo().getServiceDetailInfo().getItineraryFeeForRMB());
        OrderInfo actual = ctripFlightOrderInfoMapper.selectFlightOrder("EC1704201C9VD0QO","10605510018");
        assertThat(actual.getOrderId(),equalTo(expected.getOrderId()));
        assertThat(actual.getJourneyNo(),equalTo(expected.getJourneyNo()));
        assertThat(actual.getItineraryFee(),equalTo(expected.getItineraryFee()));

    }

    @Test(groups = {"muzi"})
    public void SearchHotelOrder() throws Throwable{
        String body = IOUtils.toString(new FileInputStream(configUtil.getTestDataPath()+"/ctrip/hotelOrderParam.json"),"UTF-8");
        CtripOrderParamDto hotelJson = new ObjectMapper().readValue(body,CtripOrderParamDto.class);
        hotelJson.getRequest().getAuth().setTicket(ctripTokenUtil.getCtripToken());
        String hotelOrderJson = JSON.toJSONString(hotelJson);

        Response response = given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .body(hotelOrderJson)
                .post("https://ct.ctrip.com/switchapi/Order/SearchOrder");

        List<ItineraryListDto> hotelInfo = response.getBody().as(CtripOrderInfoDto.class).getItineraryList();
        HotelOrderResultDto expected = new HotelOrderResultDto();
        expected.setOrderId(hotelInfo.get(1).getHotelOrderInfoList().get(0).getOrderID());
        expected.setJourneyId(hotelInfo.get(1).getHotelOrderInfoList().get(0).getJourneyNo());
        expected.setAmount(hotelInfo.get(1).getHotelOrderInfoList().get(0).getAmount());
        OrderInfo actual = ctripHotelOrderInfoMapper.getHotelOrderInfo("EC1704201C9VD0QO","10686136114");
        assertThat(actual.getOrderId(),equalTo(expected.getOrderId()));
        assertThat(actual.getJourneyNo(),equalTo(expected.getJourneyId()));
        assertThat(actual.getConsumeAmount(),equalTo(expected.getAmount()));
    }


}
