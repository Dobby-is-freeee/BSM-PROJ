package com.example.bsm.dto;

import lombok.Data;

import java.util.HashMap;

@Data
public class ResponseDto {

    private Boolean success;
    private String message;
    private HashMap<String, Object> data = new HashMap<String, Object>();
}
