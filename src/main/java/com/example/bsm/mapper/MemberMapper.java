package com.example.bsm.mapper;

import com.example.bsm.dto.Member;
import com.example.bsm.dto.PersonalScore;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MemberMapper {
    //선수 저장
    void save(Member member);

    //선수 한명 조회
    Member findOne(String playerName);

    //선수 전체 조회
    List<Member> findAll();

    //선수 경기기록 등록
    void saveRecord(PersonalScore ps);
}
