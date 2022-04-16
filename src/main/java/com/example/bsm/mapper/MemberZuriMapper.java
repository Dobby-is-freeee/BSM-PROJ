package com.example.bsm.mapper;

import com.example.bsm.common.Pagination;
import com.example.bsm.dto.MemberZuriDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MemberZuriMapper {
    
    // 전체 사용자 조회
    List<MemberZuriDto> getAllMember(Pagination pagination);

}
