package com.example.bsm.controller;

import com.example.bsm.dto.MemberZuriDto;
import com.example.bsm.dto.PersonalRecordZuriDto;
import com.example.bsm.dto.ResponseDto;
import com.example.bsm.service.PersonalRecordZuriService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("record")
public class PersonalRecordZuriController {

    HttpStatus status;
    private final PersonalRecordZuriService personalRecordZuriService;

    @Autowired
    public PersonalRecordZuriController(PersonalRecordZuriService personalRecordZuriService) {
        this.personalRecordZuriService = personalRecordZuriService;
    }

    @RequestMapping(value="", method=RequestMethod.GET)
    public ResponseEntity<ResponseDto> getAllRecord(@Param("pageIndex")int pageIndex) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("BSM", "PersonalRecord");

        ResponseDto responseDto = new ResponseDto();

        try {
            List<PersonalRecordZuriDto> record = personalRecordZuriService.getAllRecord(pageIndex);
            responseDto.getData().put("record", record);
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

    @RequestMapping(value="{memberId}", method=RequestMethod.GET)
    public ResponseEntity<ResponseDto> getPersonalRecord(@PathVariable("memberId") int memberId) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("BSM", "PersonalRecord");

        ResponseDto responseDto = new ResponseDto();

        try {
            List<PersonalRecordZuriDto> record = personalRecordZuriService.getPersonalRecord(memberId);
            responseDto.getData().put("record", record);
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
