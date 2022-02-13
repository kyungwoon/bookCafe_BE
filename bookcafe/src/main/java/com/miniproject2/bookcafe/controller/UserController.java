package com.miniproject2.bookcafe.controller;

import com.miniproject2.bookcafe.domain.User;
import com.miniproject2.bookcafe.dto.SignupRequestDto;
import com.miniproject2.bookcafe.dto.UserRequestDto;
import com.miniproject2.bookcafe.repository.UserRepository;
import com.miniproject2.bookcafe.security.JwtTokenProvider;
import com.miniproject2.bookcafe.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    //회원가입
    @PostMapping("/user/signup")
    public void registerUser(@RequestBody SignupRequestDto requestDto) {
        userService.registerUser(requestDto);
    }
//    @GetMapping("/user/login")
//    public String login(){
//        return "index";
//    }

    @PostMapping("/api/login")
    public Map<String,String> login(@RequestBody UserRequestDto requestDto) {
        User user = userRepository.findByUsername(requestDto.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 유저입니다."));
        if (!passwordEncoder.matches(requestDto.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 잘못되었습니다.");
        }

        Map<String,String>jwtLogin = new HashMap<>();
        String token = jwtTokenProvider.createToken(user.getUsername());
        String username = user.getUsername();
        jwtLogin.put("token", token);
        jwtLogin.put("username",username);

        return jwtLogin;
    }

}
