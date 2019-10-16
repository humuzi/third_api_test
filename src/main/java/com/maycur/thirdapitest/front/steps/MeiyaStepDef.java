package com.maycur.thirdapitest.front.steps;

import com.maycur.thirdapitest.front.runtime.LoginUser;
import com.maycur.thirdapitest.util.ConfigUtil;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.maycur.thirdapitest.util.MeiyaSessionIdUtil;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.io.FileInputStream;

/**
 * Create by HuQiuYue on 2019-05-28
 */
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class MeiyaStepDef extends AbstractTestNGSpringContextTests {

    @Autowired private LoginUser loginUser;
    @Autowired private ConfigUtil configUtil;
    @Autowired private MeiyaSessionIdUtil meiyaSessionIdUtil;

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
        String jsonObject = IOUtils.toString(new FileInputStream(configUtil.getTestDataPath() + "/meiyaConfig.json"),"UTF-8");

        Response response = given().accept("application/json").contentType(ContentType.JSON)
                .header("entCode","EC1804101CWRZ5L1")
                .header("tokenId",loginUser.getTokenId())
                .body(jsonObject)
                .post(configUtil.getBaseUrl() + "/meiya/changeConfigurableAttr");

        assertThat(response.getBody().asString(),response.getStatusCode(),equalTo(200));
        assertThat(response.getBody().asString(),response.getBody().jsonPath().get("code"),equalTo("ACK"));
    }

    /**
     * 同步员工至美亚
     */
    @Test(groups = {"xigua"})
    public void syncEmployee(){
        JSONObject jsonObject = new JSONObject()
                .put("companyId","S117582")
                .put("sessionId",meiyaSessionIdUtil.getSessionId())
                .put("SyncPsgList","[{\n" +
                        "\"isCreateLoginDefault\":false,\n" +
                        "\"isCreateLoginUser\":true,\n" +
                        "\"isLeave\":false,\n" +
                        "\"isRankMapping\":false,\n" +
                        "\"PassengerInfo\":{\n" +
                        "\"outsidePassengerId\":\"005\",\n" +
                        "\"passengerType\":\"成人\",\n" +
                        "\"companyId\":\"S117582\",\n" +
                        "\"cnName\":\"小蓝\",\n" +
                        "\"dName\":\"小叮当测试公司/研发/产品\",\n" +
                        "\"staffId\":\"005\"\n" +
                        "}]");

        Response response = given().accept("application/json").contentType(ContentType.JSON)
                .header("entCode","EC1804101CWRZ5L1")
                .header("tokenId",loginUser.getTokenId())
                .body(jsonObject.toString())
                .post(configUtil.getBaseUrl() + "/meiya/syncEmployees/");

        assertThat(response.getBody().asString(),response.getStatusCode(),equalTo(200));
        assertThat(response.getBody().asString(),response.getBody().jsonPath().get("code"),equalTo("ACK"));

    }

    /**
     * 同步审批人到美亚
     */
    @Test(groups = {"xigua"})
    public void syncApprover(){
        JSONObject jsonObject = new JSONObject()
                .put("approverCompanyId","S117582")
                .put("approverType","1")
                .put("compulsoryApprove","1")
                .put("outsidePassengerId","12229")
                .put("outsidePassengerName","小花")
                .put("sessionId",meiyaSessionIdUtil.getSessionId())
                .put("type","groupApprove")
                .put("approverList","[\n" +
                        "{\n" +
                        "\"approveKey\":\"一审\",\n" +
                        "\"orderType\":3,\n" +
                        "\"outsidePassengerId\":\"008\",\n" +
                        "\"outsidePassengerName\":\"小白\"\n" +
                        "}\n" +
                        "]\n" +
                        "}");

        Response response  = given().accept("application/json")
                .header("entCode","EC1804101CWRZ5L1")
                .header("tokenId",loginUser.getTokenId())
                .body(jsonObject.toString())
                .post(configUtil.getBaseUrl() + "/meiya/syncApprover");
        assertThat(response.getBody().asString(),response.getStatusCode(),equalTo(200));
        assertThat(response.getBody().asString(),response.getBody().jsonPath().get("code"),equalTo("ACK"));

    }
}
