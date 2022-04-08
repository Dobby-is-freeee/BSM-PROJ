package com.example.bsm.service;

import com.example.bsm.dto.Member;
import com.example.bsm.dto.PersonalScore;
import com.example.bsm.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private final MemberMapper memberMapper;

    @Autowired
    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    //선수 등록
    public void join(Member member) {
        memberMapper.save(member);

    }

    //선수 경기기록 등록
    public void recordReg(PersonalScore ps) {
        Member player = memberMapper.findOne(ps.getName());

        ps.setM_id(player.getId());
        memberMapper.saveRecord(ps);
    }

    //선수 전체 조회
    public List<Member> findMember() {
        return memberMapper.findAll();
    }


}
