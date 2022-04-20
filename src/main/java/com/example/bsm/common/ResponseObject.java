package com.example.bsm.common;

import lombok.Data;

import java.util.HashMap;

@Data
public class ResponseObject {

    private Boolean success;
    private String message;
    private HashMap<String, Object> data = new HashMap<String, Object>();
}
