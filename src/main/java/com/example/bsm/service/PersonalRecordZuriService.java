package com.example.bsm.service;

import com.example.bsm.common.Pagination;
import com.example.bsm.dto.PersonalRecordZuriDto;
import com.example.bsm.mapper.PersonalRecordZuriMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalRecordZuriService {

    private final PersonalRecordZuriMapper personalRecordZuriMapper;

    @Autowired
    public PersonalRecordZuriService(PersonalRecordZuriMapper personalRecordZuriMapper) {
        this.personalRecordZuriMapper = personalRecordZuriMapper;
    }

    public List<PersonalRecordZuriDto> getAllRecord(int pageIndex) {
        Pagination pagination = new Pagination();
        pagination.setStartNum((pageIndex-1) * pagination.getPerCnt());

        return personalRecordZuriMapper.getAllRecord(pagination);
    }

    public List<PersonalRecordZuriDto> getPersonalRecord(int memberId) {
        return personalRecordZuriMapper.getPersonalRecord(memberId);
    }

}
