package com.example.bsm.vo;

import java.util.HashMap;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * Created by Hyunsik Lee on 2022-04-15. Blog : https://hs95blue.github.io/ Github :
 * https://github.com/hs95blue
 */
@Data
public class MessageVO {
  private HttpStatus status;
  private String message;
  private HashMap<String,Object> data;

  public MessageVO() {
    this.status = HttpStatus.BAD_REQUEST;
    this.data = null;
    this.message = null;
  }
}
