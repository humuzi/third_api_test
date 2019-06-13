package com.maycur.thirdapitest.steps.auth;


import com.maycur.thirdapitest.util.DidiApiUtil;
import org.json.JSONObject;

/**
 * Create by HuQiuYue on 2019-06-12
 */
public class DidiStepDef {

    DidiApiUtil didiApiUtil = new DidiApiUtil();

    /**
     * 单个员工绑定
     */

    public void boundMember(){
        JSONObject jsonObject = new JSONObject()
                .put("client_id","")
                .put("access_token",didiApiUtil.getAccessToken())
                .put("timestamp",System.currentTimeMillis())
                .put("company_id","")
                .put("data","")
                .put("sign",didiApiUtil.getSign());
    }

}
