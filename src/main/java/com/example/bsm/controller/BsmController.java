package com.example.bsm.controller;

import com.example.bsm.dto.BsmDto;
import com.example.bsm.service.BsmService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BsmController {

    @Autowired
    BsmService bsmService;

    @RequestMapping(value = "/team/list", method = RequestMethod.GET)
    public List<BsmDto> getTeamList() {
        System.out.println("RestController : /team/list");
        List<BsmDto> bsmDto = bsmService.getTeamList();
        System.out.println(bsmDto);

        return bsmDto;
    }

}
