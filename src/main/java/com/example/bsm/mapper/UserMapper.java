package com.example.bsm.mapper;

import com.example.bsm.vo.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public interface UserMapper {

    int save(Map user);

    HashMap findByEmail(String email);
}
