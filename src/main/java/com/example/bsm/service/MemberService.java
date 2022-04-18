package com.example.bsm.service;

import com.example.bsm.vo.MemberVO;
import com.example.bsm.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Hyunsik Lee on 2022-04-15. Blog : https://hs95blue.github.io/ Github :
 * https://github.com/hs95blue
 */
@Service
public class MemberService {

    @Autowired
    MemberMapper memberMapper;

    /**
     * 샘플입니다
     * @param memberVO
     * @return
     */
    public int sample(MemberVO memberVO) throws Exception {
        int result = 0;
        try {
            result = memberMapper.insertMember(memberVO); // 샘플입니다 예시로 그냥 넣어둔거에욤
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    /**
     * @param memberVO
     * @return
     */
    public int signUp(MemberVO memberVO) throws Exception {
        int result = 0;
        try {
            result = memberMapper.insertMember(memberVO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    /**
     * @param memberVO
     * @return
     */
    public boolean signIn(MemberVO memberVO) throws Exception  {
        int result = 0;
        try {
            result = memberMapper.loginChk(memberVO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result == 1 ? true : false;
    }

    /**
     * @param memberVO
     */
    public void signOut(MemberVO memberVO) throws Exception  {

    }

    /**
     * @param memberVO
     * @return
     */
    public int updatePw(MemberVO memberVO) {
        return 0;
    }
}
