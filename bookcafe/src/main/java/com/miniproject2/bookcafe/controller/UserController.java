package com.miniproject2.bookcafe.controller;

import com.miniproject2.bookcafe.dto.SignupRequestDto;
import com.miniproject2.bookcafe.dto.UserResponseDto;
import com.miniproject2.bookcafe.repository.UserRepository;
import com.miniproject2.bookcafe.security.UserDetailsImpl;
import com.miniproject2.bookcafe.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    //    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    //회원가입
    @PostMapping("/user/signup")
    public void registerUser(@RequestBody SignupRequestDto requestDto) {
        userService.registerUser(requestDto);
    }

    @PostMapping("/user/islogin")
    public UserResponseDto islogin(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return new UserResponseDto(userDetails);
    }
}

//    @GetMapping("/user/login")
//    public String login(){
//        return "login";
//    }

//    @PostMapping("/user/login")
//    public List<Map<String,String>> login(@RequestBody SignupRequestDto signupDto) {
//        User user = userRepository.findByUsername(signupDto.getUsername())
//                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 유저입니다."));
//        if (!passwordEncoder.matches(signupDto.getPassword(), user.getPassword())) {
//            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
//        }
//
//        // 토큰 찾아오기
//        Map<String,String> username =new HashMap<>();
//        Map<String,String>token = new HashMap<>();
//        List<Map<String,String>> tu = new ArrayList<>(); // -> 리스트를 만드는데, Map형태(키:밸류 형태)의 변수들을 담을 것이다.
//
//        token.put("token",jwtTokenProvider.createToken(signupDto.getUsername())); // "username" : {username}
//        username.put("username",user.getUsername()); // "token" : {token}
//        tu.add(username); //List형태 ["username" : {username}]
//        tu.add(token); //List형태 ["token" : {token}]
//        return tu; // List형태 ["username" : {username}, "token" : {token}]
//    }

