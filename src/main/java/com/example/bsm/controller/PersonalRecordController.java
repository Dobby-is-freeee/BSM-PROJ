package com.example.bsm.controller;

import com.example.bsm.service.PersonalRecordService;
import com.example.bsm.vo.MessageVO;
import com.example.bsm.vo.PersonalRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonalRecordController {

    PersonalRecordService personalRecordService;

    @Autowired
    public PersonalRecordController(PersonalRecordService personalRecordService){
        this.personalRecordService = personalRecordService;
    }

    //선수 개인 기록 등록 view 페이지 이동
    @GetMapping(value="/personals")
    public String personalRecordRegiste(){
        return "";
    }

    //선수 개인 기록 등록
    @RequestMapping(value="/personals", method= RequestMethod.POST, headers={"Content-type=application/json"})
    @ResponseBody
    public ResponseEntity<MessageVO> personalRecordRegiste(@RequestBody PersonalRecordVO personalRecordVO){
        int dbResult;
        HttpHeaders headers = new HttpHeaders();
        headers.set("BSM", "PersonalRecordRegister");
        MessageVO messagevo = new MessageVO();

        try{
            //등록 선수 memberId 값 세팅
            personalRecordVO.setMemberId(findMemberId(personalRecordVO.getName()));

            dbResult = personalRecordService.setPersonalRecord(personalRecordVO);
            if(dbResult < 0){
                throw new Exception();
            }else {
                messagevo.setMessage("선수기록 등록을 성공하였습니다.");
                messagevo.setStatus(HttpStatus.OK);
            }
        }catch (Exception e){
            messagevo.setMessage("선수기록 등록을 실패하였습니다.");
            e.printStackTrace();
        }

        return ResponseEntity.status(messagevo.getStatus()).headers(headers).body(messagevo);
    }

    //선수 개인 기록 수정


    public int findMemberId(String name){
        return personalRecordService.getMemberId(name);
    }





}
