package com.example.bsm.controller;

import com.example.bsm.dto.Member;
import com.example.bsm.dto.MemberForm;
import com.example.bsm.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by Hyunsik Lee on 2022-03-31. Blog : https://hs95blue.github.io/ Github :
 * https://github.com/hs95blue
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String Home() {
        return "home";
    }


}
