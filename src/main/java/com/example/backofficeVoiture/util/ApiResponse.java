package com.example.backofficeVoiture.util;

import java.util.Map;

public class ApiResponse {

    String message;

    Map<String, Object> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
