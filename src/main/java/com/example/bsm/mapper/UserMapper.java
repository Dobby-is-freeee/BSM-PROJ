package com.example.bsm.mapper;

import com.example.bsm.vo.User;
import com.fasterxml.jackson.databind.deser.UnresolvedId;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserMapper {

    UnresolvedId save(User build);

    Optional<User> findByEmail(String email);
}
