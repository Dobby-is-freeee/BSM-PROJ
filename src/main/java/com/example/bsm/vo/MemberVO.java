package com.example.bsm.vo;

import lombok.Data;

@Data
public class MemberVO {
  private Long id;
  private String email;
  private String password;
  private String name;
  private String position;
}
