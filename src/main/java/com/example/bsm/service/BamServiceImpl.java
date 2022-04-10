package com.example.bsm.service;

import com.example.bsm.dto.BsmDto;
import com.example.bsm.mapper.BsmMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BamServiceImpl implements BsmService {


    BsmMapper bsmMapper;

    @Override
    public List<BsmDto> getTeamList() {
        System.out.println("BamServiceImpl");
        List<BsmDto> bsmDto = bsmMapper.getTeamList();
        System.out.println("BamServiceImpl/bsmDto : " + bsmDto);
        return bsmDto;
    }
}
