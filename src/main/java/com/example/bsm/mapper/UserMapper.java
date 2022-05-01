package com.example.bsm.mapper;

import com.example.bsm.vo.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserMapper {

    int save(User user);

    Optional<User> findByEmail(String email);
}
