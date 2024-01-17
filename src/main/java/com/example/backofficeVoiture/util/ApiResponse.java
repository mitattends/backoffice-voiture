package com.example.backofficeVoiture.util;

import java.util.HashMap;
import java.util.Map;

public class ApiResponse {

    String message;

    Map<String, Object> data= new HashMap<>();

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void addData(String nom, Object value) {
        this.data.put(nom, value);
    }

    public ApiResponse() {
    }

    public ApiResponse(String message, Map<String, Object> data) {
        setMessage(message);
        setData(data);
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

}
