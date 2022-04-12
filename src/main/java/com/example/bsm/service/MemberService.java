package com.example.bsm.service;

import com.example.bsm.dto.Member;
import com.example.bsm.dto.PersonalScore;
import com.example.bsm.dto.PersonalScoreForm;
import com.example.bsm.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public void recordReg(PersonalScoreForm psf) throws ParseException {
        //PersonalScore 의 경기날짜 필더값 맞추기
        String dateStr = psf.getPlay_date();
        // 포맷터
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        // 문자열 -> Date
        Date date = formatter.parse(dateStr);
        
        PersonalScore ps = new PersonalScore();
        ps.setName(psf.getName());
        ps.setScore(psf.getScore());
        ps.setAssist(psf.getAssist());
        ps.setRebound(psf.getRebound());
        ps.setSteal(psf.getSteal());
        ps.setBlock(psf.getBlock());
        ps.setPoint2(psf.getPoint2());
        ps.setPoint3(psf.getPoint3());
        ps.setFreeshot(psf.getFreeshot());
        ps.setPlay_date(date);

        //입력한 선수이름의 id 값 찾기
        Member player = memberMapper.findOne(ps.getName());
        
        //선수의 id값 넣어주기
        ps.setMemberId(player.getId());

        memberMapper.saveRecord(ps);
    }

    //선수 전체 조회
    public List<PersonalScore> findMemberRecord() throws ParseException {

        return memberMapper.findAll();
    }


}
