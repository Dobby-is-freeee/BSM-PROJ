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


<<<<<<< HEAD
=======
    //선수 경기기록 등록
    void saveRecord(PersonalScore ps);

    //이메일 찾기
    Member findEmail(Member member);

    //비밀번호 변경 본인인증
    Member passwordChangeAuth(Member member);

    //사용자 조회
    Member checkUser(Member member);

    //사용자 삭제
    void deleteUser(Member member);
>>>>>>> 4225465bca098fd638dfa8663955ada899cd64c3
}
