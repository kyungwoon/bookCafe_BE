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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    @PostMapping("/user/login")
    public List<Map<String,String>> login(@RequestBody SignupRequestDto requestDto) {

        User user = userService.login(requestDto.getUsername(), requestDto.getPassword());

        Map<String,String> username =new HashMap<>();
        Map<String,String>token = new HashMap<>();
        List<Map<String,String>> jwtLogin = new ArrayList<>(); // 리스트를 만드는데, Map형태(키:밸류 형태)의 변수들을 담는다.
        token.put("token",jwtTokenProvider.createToken(requestDto.getUsername())); // "username" : {username}
        username.put("username",user.getUsername()); // "token" : {token}
        jwtLogin.add(username); //List형태 ["username" : {username}]
        jwtLogin.add(token); //List형태 ["token" : {token}]

        return jwtLogin;
    }
}
