package com.example.bsm.mapper;

import com.example.bsm.common.Pagination;
import com.example.bsm.dto.PersonalRecordZuriDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PersonalRecordZuriMapper {
    
    // 개인기록 전체조회
    List<PersonalRecordZuriDto> getAllRecord(Pagination pagination);

}
