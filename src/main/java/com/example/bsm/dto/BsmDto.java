package com.example.bsm.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class BsmDto {
    private int id;
    private String teamName;
    private String area;
    private Date createDate;
    private Date deleteDate;
    private Date modifyDate;
}
