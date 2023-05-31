package com.pesapauniversity.utils;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedHashMap;

@Component
public class TransactionResponse {
    public HashMap<String,Object> genericResponse(Object value, Object value1){
        HashMap<String,Object> map = new LinkedHashMap<>();
        map.put("ResponseHeader", value);
        map.put("ResponseBody", value1);

        return map;
    }

}
