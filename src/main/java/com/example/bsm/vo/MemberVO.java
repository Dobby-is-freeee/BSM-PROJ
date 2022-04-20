package com.example.bsm.vo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class MemberVO {
  private Long id;
  private String email;
  private String password;
  private String name;
  private String position;
  private Timestamp deleteDate;
}
