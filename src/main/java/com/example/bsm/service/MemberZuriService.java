package com.example.bsm.service;

import com.example.bsm.common.Pagination;
import com.example.bsm.dto.MemberZuriDto;
import com.example.bsm.mapper.MemberZuriMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberZuriService {

    private final MemberZuriMapper memberZuriMapper;

    @Autowired
    public MemberZuriService(MemberZuriMapper memberZuriMapper) {
        this.memberZuriMapper = memberZuriMapper;
    }

    public List<MemberZuriDto> getAllMember(int pageIndex) {
        Pagination pagination = new Pagination();
        pagination.setStartNum((pageIndex-1) * pagination.getPerCnt());

        return memberZuriMapper.getAllMember(pagination);
    }

}
