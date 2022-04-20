package com.example.bsm.mapper;

import com.example.bsm.common.Pagination;
import com.example.bsm.vo.PersonalRecordVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalRecordMapper {

    int selectMemberId(String name);

    int insertPersonalRecord(PersonalRecordVO personalRecordVO);

    int updatePersonalRecord(PersonalRecordVO personalRecordVO);

    int deletePersonalRecord(long id);

    // 기록 전체 조회
    List<PersonalRecordVO> getAllRecord(Pagination pagination);

    // 사용자 기록 전체 조회
    List<PersonalRecordVO> getPersonalRecord(long memberId);
}
