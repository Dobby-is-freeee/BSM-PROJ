package com.example.bsm.dto;

import com.example.bsm.common.Pagination;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemberZuriDto {

    private int id;
    private String name;
    private String email;
    private String position;

}
