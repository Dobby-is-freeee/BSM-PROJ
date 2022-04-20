package com.example.bsm.service;

import com.example.bsm.common.Pagination;
import com.example.bsm.mapper.PersonalRecordMapper;
import com.example.bsm.vo.PersonalRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalRecordService {

    PersonalRecordMapper personalRecordMapper;

    @Autowired
    public PersonalRecordService(PersonalRecordMapper personalRecordMapper){
        this.personalRecordMapper = personalRecordMapper;
    }

    /**
     * 전체기록 조회
     * @param pageIndex
     * @return
     */
    public List<PersonalRecordVO> getAllRecord(int pageIndex) {
        Pagination pagination = new Pagination();
        pagination.setStartNum((pageIndex-1) * pagination.getPerCnt());

        return personalRecordMapper.getAllRecord(pagination);
    }

    /**
     * 사용자 전체 기록 조회
     * @param memberId
     * @return
     */
    public List<PersonalRecordVO> getPersonalRecord(long memberId) {
        return personalRecordMapper.getPersonalRecord(memberId);
    }

    //선수기록 등록
    public int setPersonalRecord(PersonalRecordVO personalRecordVO) {
        return personalRecordMapper.insertPersonalRecord(personalRecordVO);
    }

    //선수 이름으로 memberId 찾기
    public long getMemberId(String name) {
        return personalRecordMapper.selectMemberId(name);
    }

    //선수기록 수정
    public int editPersonalRecord(PersonalRecordVO personalRecordVO) {
        return personalRecordMapper.updatePersonalRecord(personalRecordVO);
    }

    public int deletePersonalRecord(long id) {
        return personalRecordMapper.deletePersonalRecord(id);
    }
}
