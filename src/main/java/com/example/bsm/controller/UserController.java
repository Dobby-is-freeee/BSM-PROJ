package com.example.bsm.controller;

import com.example.bsm.jwt.JwtTokenProvider;
import com.example.bsm.mapper.UserMapper;
import com.example.bsm.vo.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserMapper userMapper;

    // 회원가입
    @PostMapping("/join")
    public int join(@RequestBody Map<String, String> user) {
        return userMapper.save(User.builder()
                .email(user.get("email"))
                .password(passwordEncoder.encode(user.get("password")))
                .roles(Collections.singletonList("ROLE_ADMIN")) // 최초 가입시 USER 로 설정
                .build());
    }

    //로그인
    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> user) {
        User member = userMapper.findByEmail(user.get("email"))
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 E-mail 입니다."));

        if (!passwordEncoder.matches(user.get("password"),"{noop}" + member.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        return jwtTokenProvider.createToken(member.getUsername(), member.getRoles());
    }

    //권한 확인


}
