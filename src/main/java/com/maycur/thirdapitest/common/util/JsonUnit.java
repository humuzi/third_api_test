package com.maycur.thirdapitest.common.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.*;

import org.json.*;

/**
 * Create by HuQiuYue on 2019-04-08
 */
public class JsonUnit {
    public static Map<String,Object> toMap(JSONObject json){
        Map<String,Object> map = new HashMap<>();
        Iterator<String> jsonStr = json.keys();
        while(jsonStr.hasNext()){
            String key = jsonStr.next();
            Object value = json.get(key);
            if(value instanceof JSONArray)
                value = toList((JSONArray) value);
            if(value instanceof JSONObject)
                value = toMap((JSONObject) value);

            map.put(key,value);
        }
        return map;
    }

    public static List<Object> toList(JSONArray array){
        List<Object> list = new ArrayList<>();
        for(int i = 0;i <array.length();i++){
            Object value = list.get(i);
            if(value instanceof JSONObject)
                value = toMap((JSONObject) value);
            if(value instanceof JSONArray)
                value = toList((JSONArray) value);

            list.add(value);
        }
        return list;
    }


    public static JSONObject mapToJson(Map<String,String> map){
        JSONObject json = new JSONObject();
        for(String key: map.keySet()){
            map.put(key,map.get(key));
        }
        return json;
    }

    public static JSONArray mapListToJson(List<Map<String,String>>  list){
        JSONArray jsonArray = new JSONArray();
        for(Map<String,String> map :list){
            jsonArray.put(map);
        }

        return jsonArray;
    }

    public static List<Map<String,String>> jsonToMapList(JSONArray array){
        List<Map<String,String>> list = new ArrayList<>();
        List<Object>  objectList = toList(array);
        for(Object item:list)
            if(item instanceof Map)
                objectList.add(item);

        return list;
    }
}
