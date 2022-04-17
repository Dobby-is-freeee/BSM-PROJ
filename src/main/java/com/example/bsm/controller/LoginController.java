package com.example.bsm.controller;

import com.example.bsm.vo.MemberVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Hyunsik Lee on 2022-04-17. Blog : https://hs95blue.github.io/ Github :
 * https://github.com/hs95blue
 */
@RestController
public class LoginController {

  /**
   * @param memberVO
   * @return
   */
  @GetMapping("/sample")
  public String sample(MemberVO memberVO){
    return "";

  }

}
