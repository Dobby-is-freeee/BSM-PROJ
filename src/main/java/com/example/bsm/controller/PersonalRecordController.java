package com.example.bsm.controller;

import com.example.bsm.service.PersonalRecordService;
import com.example.bsm.vo.MessageVO;
import com.example.bsm.vo.PersonalRecordVO;
import org.apache.ibatis.annotations.Param;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PersonalRecordController {

    HttpStatus status;
    PersonalRecordService personalRecordService;

    @Autowired
    public PersonalRecordController(PersonalRecordService personalRecordService){
        this.personalRecordService = personalRecordService;
    }

    //선수 개인 기록 등록
    @RequestMapping(value="/personals", method= RequestMethod.POST, headers={"Content-type=application/json"})
    @ResponseBody
    public ResponseEntity<MessageVO> personalRecordRegiste(@RequestBody PersonalRecordVO personalRecordVO){
        int dbResult;
        HttpHeaders headers = new HttpHeaders();
        headers.set("BSM", "PersonalRecordRegiste");
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
    @RequestMapping(value="/personals/{id}", method=RequestMethod.PUT, headers={"Content-type=application/json"})
    @ResponseBody
    public ResponseEntity<MessageVO> personalRecordEdit(@RequestBody PersonalRecordVO personalRecordVO, @PathVariable long id){
        int dbResult;
        HttpHeaders headers = new HttpHeaders();
        headers.set("BSM", "PersonalRecordUpdate");
        MessageVO messagevo = new MessageVO();

        try{
            personalRecordVO.setId(id);
            //등록 선수 memberId 값 세팅
            personalRecordVO.setMemberId(findMemberId(personalRecordVO.getName()));

            dbResult = personalRecordService.editPersonalRecord(personalRecordVO);
            if(dbResult <= 0){
                throw new Exception();
            }else {
                messagevo.setMessage("선수기록 수정을 성공하였습니다.");
                messagevo.setStatus(HttpStatus.OK);
            }
        }catch (Exception e){
            messagevo.setMessage("선수기록 수정을 실패하였습니다.");
            e.printStackTrace();
        }

        return ResponseEntity.status(messagevo.getStatus()).headers(headers).body(messagevo);
    }

    //선수기록 삭제
    @RequestMapping(value="/personals/{id}", method=RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<MessageVO> personalRecordDelete(@PathVariable long id){
        int dbResult;
        HttpHeaders headers = new HttpHeaders();
        headers.set("BSM", "PersonalRecordDelete");
        MessageVO messagevo = new MessageVO();

        try{                        
            dbResult = personalRecordService.deletePersonalRecord(id);
            if(dbResult <= 0){
                throw new Exception();
            }else {
                messagevo.setMessage("선수기록 삭제를 성공하였습니다.");
                messagevo.setStatus(HttpStatus.OK);
            }
        }catch (Exception e){
            messagevo.setMessage("선수기록 삭제를 실패하였습니다.");
            e.printStackTrace();
        }

        return ResponseEntity.status(messagevo.getStatus()).headers(headers).body(messagevo);
    }

    public long findMemberId(String name){
        return personalRecordService.getMemberId(name);
    }

    /**
     * 전체 기록 조회
     * @param pageIndex
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/personals", method=RequestMethod.GET)
    public ResponseEntity<MessageVO> getAllRecord(@Param("pageIndex")int pageIndex) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("BSM", "PersonalRecord");

        MessageVO responseDto = new MessageVO();

        try {
            List<PersonalRecordVO> record = personalRecordService.getAllRecord(pageIndex);
            responseDto.getData().put("record", record);
            responseDto.getData().put("pageIndex", pageIndex);
            status = HttpStatus.OK;
        } catch (Exception e) {
            status = HttpStatus.BAD_REQUEST;
            e.printStackTrace();
        }

        return ResponseEntity.status(status)
                .headers(headers)
                .body(responseDto);

    }

    /**
     * 사용자 전체 기록 조회
     * @param memberId
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/personals/{memberId}", method=RequestMethod.GET)
    public ResponseEntity<MessageVO> getPersonalRecord(@PathVariable("memberId") long memberId) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("BSM", "PersonalRecord");

        MessageVO responseDto = new MessageVO();

        try {
            List<PersonalRecordVO> record = personalRecordService.getPersonalRecord(memberId);
            responseDto.getData().put("record", record);
            status = HttpStatus.OK;
        } catch (Exception e) {
            status = HttpStatus.BAD_REQUEST;
            e.printStackTrace();
        }

        return ResponseEntity.status(status)
                .headers(headers)
                .body(responseDto);
    }

}
