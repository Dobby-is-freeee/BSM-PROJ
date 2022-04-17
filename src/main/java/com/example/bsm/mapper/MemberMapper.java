package com.example.bsm.mapper;

import com.example.bsm.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MemberMapper {

    public int insertMember(MemberVO memberVO);     // 회원가입

    public int loginChk(MemberVO memberVO);     // 로그인

    public int updatePassword(MemberVO memberVO);   // 비밀번호 변경


}
