package com.example.bsm.mapper;

import com.example.bsm.dto.BsmDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BsmMapper {
    List<BsmDto> getTeamList();

}
