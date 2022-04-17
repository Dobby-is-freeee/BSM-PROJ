package com.example.bsm.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ScoreVO {
  private Long memberId;
  private String name;
  private Long score;
  private Long assist;
  private Long rebound;
  private Long steal;
  private Long block;
  private Long point2;
  private Long point3;
  private Long freeShot;
  private Date playDate;

}
