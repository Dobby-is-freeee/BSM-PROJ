package com.example.bsm.mapper;

import com.example.bsm.vo.PersonalRecordVO;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalRecordMapper {

    int selectMemberId(String name);

    int insertPersonalRecord(PersonalRecordVO personalRecordVO);

    int updatePersonalRecord(PersonalRecordVO personalRecordVO);

    int deletePersonalRecord(int id);
}
