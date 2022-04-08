package com.example.bsm.controller;

import com.example.bsm.dto.Member;
import com.example.bsm.dto.MemberForm;
import com.example.bsm.dto.PersonalScore;
import com.example.bsm.dto.PersonalScoreForm;
import com.example.bsm.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {

        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setEmail(form.getEmail());
        member.setPassword(form.getPassword());
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members/personalRecord")
    public String recordRegistForm(){
        return "members/registerRecordForm";
    }

    @PostMapping("/members/personalRecord")
    public String recordRegister(PersonalScoreForm scoreForm) throws ParseException {
        String dateStr = scoreForm.getPlayDate();
        // 포맷터
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        // 문자열 -> Date
        Date date = formatter.parse(dateStr);


        PersonalScore ps = new PersonalScore();
        ps.setName(scoreForm.getName());
        ps.setScore(scoreForm.getScore());
        ps.setAssist(scoreForm.getAssist());
        ps.setRebound(scoreForm.getRebound());
        ps.setSteal(scoreForm.getSteal());
        ps.setBlock(scoreForm.getBlock());
        ps.setPoint2(scoreForm.getPoint2());
        ps.setPoint3(scoreForm.getPoint3());
        ps.setFt(scoreForm.getFt());
        ps.setPlayDate(date);

        memberService.recordReg(ps);

        return "redirect:/";
    }


    @GetMapping("/members")
    public String list(Model model) {
        List<Member> memberList = memberService.findMember();
        model.addAttribute("memberList", memberList);

        return "members/memberList";
    }

}
