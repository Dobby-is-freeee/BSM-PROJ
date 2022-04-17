package com.example.bsm.controller;

<<<<<<< HEAD
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

=======
import com.example.bsm.dto.Member;
import com.example.bsm.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@RestController
public class LoginController {

    @Autowired
    MemberService memberService;

    /**
     * 사용자 이메일 찾기
     *
     * @param member
     * @return
     * @throws JSONException
     */
    @GetMapping(value = "/members/id", produces = "application/json; charset=UTF-8;")
    public HashMap findEmail(@RequestBody Member member) throws JSONException {

        HashMap hashMap = new HashMap();

        try {
            member = memberService.findEmail(member);
            member.setEmail(member.getEmail());
            hashMap.put("email", member.getEmail());

            hashMap.put("success", true);
            hashMap.put("code", HttpStatus.OK.value());
            hashMap.put("message", HttpStatus.OK.getReasonPhrase());
        } catch (NullPointerException e) {
            hashMap.put("e", HttpStatus.BAD_REQUEST.value());
            hashMap.put("message", HttpStatus.BAD_REQUEST.getReasonPhrase());
        } catch (Exception e) {
            hashMap.put("e", e);
        }

        return hashMap;
    }


    /**
     * 사용자 패스워드 본인인증
     *
     * @param member
     * @return
     * @throws JSONException
     */
    @GetMapping(value = "/members/password", produces = "application/json; charset=UTF-8;")
    public HashMap passwordChangeAuth(@RequestBody Member member) throws JSONException {

        HashMap hashMap = new HashMap();

        Member checkMember = new Member();
        try {
            checkMember = memberService.passwordChangeAuth(member);


            //1. 프로세스 : 로그인된 세션에 저장된 키값을 통해 로그인된 계정과 조회된 계정을 비교
            //2. try 문을 사용함으로 인해 null 체크 시 커스텀 불가


            /*if(checkMember == null){
                hashMap.put("success", false );
                hashMap.put("code", HttpStatus.OK.value() );
                hashMap.put("message", "정보가 일치하지 않습니다.");
            }*/
            if (!checkMember.equals("") && checkMember != null) {
                hashMap.put("success", true);
                hashMap.put("code", HttpStatus.OK.value());
                hashMap.put("message", HttpStatus.OK.getReasonPhrase());
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            hashMap.put("e", HttpStatus.BAD_REQUEST.value());
            hashMap.put("message", HttpStatus.BAD_REQUEST.getReasonPhrase());
        } catch (Exception e) {
            hashMap.put("e", e);
        }

        return hashMap;
    }


    /**
     * 사용자 삭제
     *
     * @return
     * @throws JSONException
     * @paam member
     */
    @DeleteMapping(value = "/members/{id}", produces = "application/json; charset=UTF-8;")
    public HashMap deleteUser(Member member, @PathVariable Long id) throws JSONException {

        HashMap hashMap = new HashMap();
        Member checkMember = new Member();

        member.setId(id);
        checkMember = memberService.checkUser(member);

        if (checkMember.getDeleteDate() == null || checkMember.getDeleteDate().equals("")) {
            try {
                memberService.deleteUser(member);
                hashMap.put("success", true);
                hashMap.put("code", HttpStatus.OK.value());
                hashMap.put("message", "정상적으로 삭제되었습니다.");
            } catch (NullPointerException e) {
                hashMap.put("e", HttpStatus.BAD_REQUEST.value());
                hashMap.put("message", HttpStatus.BAD_REQUEST.getReasonPhrase());
            } catch (Exception e) {
                hashMap.put("e", e);
            }
        } else {
            hashMap.put("code", HttpStatus.BAD_REQUEST.value());
            hashMap.put("message", "이미 삭제된 회원입니다.");
        }

        return hashMap;
    }
>>>>>>> 4225465bca098fd638dfa8663955ada899cd64c3
}
