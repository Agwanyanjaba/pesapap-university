package com.pesapauniversity.utils;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedHashMap;

@Component
public class TransactionResponse {
    public HashMap<String,Object> genericResponse(Object header, Object body){
        HashMap<String,Object> map = new LinkedHashMap<>();
        map.put("ResponseHeader", header);
        map.put("ResponseBody", body);

        return map;
    }

}
