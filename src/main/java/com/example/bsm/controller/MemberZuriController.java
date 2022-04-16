package com.example.bsm.controller;

import com.example.bsm.dto.MemberZuriDto;
import com.example.bsm.dto.ResponseDto;
import com.example.bsm.service.MemberZuriService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("members")
public class MemberZuriController {

    HttpStatus status;
    final private MemberZuriService memberZuriService;

    @Autowired
    public MemberZuriController(MemberZuriService memberZuriService) {
        this.memberZuriService = memberZuriService;
    }

    @RequestMapping(value="", method= RequestMethod.GET)
    public ResponseEntity<ResponseDto> getAllMember(@Param("pageIndex")int pageIndex) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("BSM", "Members");

        ResponseDto responseDto = new ResponseDto();

        try {
            List<MemberZuriDto> members = memberZuriService.getAllMember(pageIndex);
            responseDto.getData().put("members", members);
            responseDto.getData().put("pageIndex", pageIndex);
            responseDto.setSuccess(true);
            status = HttpStatus.OK;
        } catch (Exception e) {
            responseDto.setSuccess(false);
            status = HttpStatus.BAD_REQUEST;
            e.printStackTrace();
        }

        return ResponseEntity.status(status)
                .headers(headers)
                .body(responseDto);

    }

}
