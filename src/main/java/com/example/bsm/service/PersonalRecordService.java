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

    //선수기록 등록
    public int setPersonalRecord(PersonalRecordVO personalRecordVO) {
        return personalRecordMapper.insertPersonalRecord(personalRecordVO);
    }

    //선수 이름으로 memberId 찾기
    public int getMemberId(String name) {
        return personalRecordMapper.selectMemberId(name);
    }

    //선수기록 수정
    public int editPersonalRecord(PersonalRecordVO personalRecordVO) {
        return personalRecordMapper.updatePersonalRecord(personalRecordVO);
    }

    public int deletePersonalRecord(int id) {
        return personalRecordMapper.deletePersonalRecord(id);
    }
}
