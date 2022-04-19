package com.example.bsm.service;

import com.example.bsm.mapper.PersonalRecordMapper;
import com.example.bsm.vo.PersonalRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalRecordService {

    PersonalRecordMapper personalRecordMapper;

    @Autowired
    public PersonalRecordService(PersonalRecordMapper personalRecordMapper){
        this.personalRecordMapper = personalRecordMapper;
    }


    public int setPersonalRecord(PersonalRecordVO personalRecordVO) {
        return personalRecordMapper.insertPersonalRecord(personalRecordVO);
    }

    public int getMemberId(String name) {
        return personalRecordMapper.selectMemberId(name);
    }
}
