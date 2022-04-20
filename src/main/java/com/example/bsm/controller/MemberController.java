package com.example.bsm.controller;

import com.example.bsm.vo.MemberVO;
import com.example.bsm.vo.MessageVO;
import com.example.bsm.service.MemberService;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {
    @Autowired
    MemberService memberService;


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
     * 사용자 이메일 찾기
     * @param memberVO
     * @return
     */
    @GetMapping(value = "/members/id")
    public ResponseEntity<MessageVO> findEmail(@RequestBody MemberVO memberVO){
        MessageVO message = new MessageVO();
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        HttpStatus status = HttpStatus.OK;

        try {
            memberVO = memberService.findEmail(memberVO);
            memberVO.setEmail(memberVO.getEmail());

            message.setStatus(HttpStatus.OK);
            message.setMessage(memberVO.getName() + " 님의 이메일은 "+ memberVO.getEmail()+" 입니다.");
            message.getData().put("email", memberVO.getEmail());

        } catch (NullPointerException e) {
            message.setStatus(HttpStatus.BAD_REQUEST);
            message.setMessage("조회된 이메일이 없습니다.");
        } catch (Exception e) {
            message.setMessage(String.valueOf(e));
        }

        return new ResponseEntity<>(message, headers, status);
    }


    /**
     * 사용자 패스워드 본인인증
     * @param memberVO
     * @return
     * @throws JSONException
     */
    @GetMapping(value = "/members/password")
    public ResponseEntity<MessageVO> passwordChangeAuth(@RequestBody MemberVO memberVO) throws JSONException {
        MessageVO message = new MessageVO();
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        HttpStatus status = HttpStatus.OK;

        HashMap hashMap = new HashMap();

        MemberVO checkMember = new MemberVO();
        try {
            checkMember = memberService.passwordChangeAuth(memberVO);
            if (!checkMember.equals("") && checkMember != null) {
                message.setStatus(HttpStatus.OK);
                message.setMessage("인증이 완료되었습니다.");
            }
        } catch (NullPointerException e) {
            message.setStatus(HttpStatus.BAD_REQUEST);
            message.setMessage("인증되지 않았습니다.");
        } catch (Exception e) {
            message.setMessage(String.valueOf(e));
        }
        return new ResponseEntity<>(message, headers, status);
    }


    /**
     * 사용자 삭제
     * @return
     * @throws JSONException
     * @paam member
     */
    @DeleteMapping(value = "/members/{id}")
    public ResponseEntity<MessageVO> deleteUser(MemberVO memberVO, @PathVariable Long id) throws JSONException {
        MessageVO message = new MessageVO();
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        HttpStatus status = HttpStatus.OK;

        HashMap hashMap = new HashMap();
        MemberVO checkMember = new MemberVO();

        memberVO.setId(id);
        checkMember = memberService.checkUser(memberVO);

        if (checkMember.getDeleteDate() == null || checkMember.getDeleteDate().equals("")) {
            try {
                memberService.deleteUser(memberVO);

                message.setStatus(HttpStatus.OK);
                message.setMessage("정상적으로 삭제되었습니다.");
            } catch (NullPointerException e) {
                message.setStatus(HttpStatus.BAD_REQUEST);
                message.setMessage("조회된 회원이 없습니다.");
            } catch (Exception e) {
                message.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
                message.setMessage(String.valueOf(e));
            }
        } else {
            message.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            message.setMessage("이미 삭제된 회원입니다.");
        }
        return new ResponseEntity<>(message, headers, status);
    }
}
