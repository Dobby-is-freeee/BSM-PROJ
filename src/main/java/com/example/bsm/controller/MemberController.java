package com.example.bsm.controller;

import com.example.bsm.common.ResponseObject;
import com.example.bsm.vo.MemberVO;
import com.example.bsm.vo.MessageVO;
import com.example.bsm.service.MemberService;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {
    @Autowired
    MemberService memberService;
    HttpStatus status;

    /**
     * 샘플입니다
     * @param memberVO
     * @return
     */
    @PostMapping("/members/sample")
    public ResponseEntity<MessageVO> sample(@RequestBody MemberVO memberVO) {
        MessageVO message = new MessageVO();
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        HttpStatus status = HttpStatus.OK;
        try {
            memberService.sample(memberVO);
            message.setStatus(HttpStatus.OK);
            message.setMessage("사용자한테 보여질 메세지");
            message.getData().put("보내주고 싶은 데이터","내용"); // 조회시 보낼 데이터 이렇게 넣어주세요
            // message.setData(); 데이터 넣을게 없음..
        } catch (Exception e) {
            System.out.println(e.getMessage());
            message.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            message.setMessage("사용자한테 보여질 메세지");
        }
        return new ResponseEntity<>(message, headers, status);
    }


    /**
     * 회원가입
     * @param memberVO
     * @return
     */
    @PostMapping("/members")
    public ResponseEntity<MessageVO> signUp(@RequestBody MemberVO memberVO) {
        MessageVO message = new MessageVO();
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        HttpStatus status = HttpStatus.OK;
        try {
            memberService.signUp(memberVO);
            message.setStatus(HttpStatus.OK);
            message.setMessage("회원가입이 완료되었습니다.");
            // message.setData(); 데이터 넣을게 없음..
        } catch (Exception e) {
            System.out.println(e.getMessage());
            message.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            message.setMessage("회원가입이 실패하였습니다.");
        }
        return new ResponseEntity<>(message, headers, status);
    }

    /**
     * 사용자 전체조회
     * @param pageIndex
     * @return
     */
    @RequestMapping(value="/members", method= RequestMethod.GET)
    public ResponseEntity<ResponseObject> getAllMember(@Param("pageIndex")int pageIndex) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("BSM", "Members");

        ResponseObject responseDto = new ResponseObject();

        try {
            List<MemberVO> members = memberService.getAllMember(pageIndex);
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
