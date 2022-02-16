package com.miniproject2.bookcafe.controller;

import com.miniproject2.bookcafe.domain.User;
import com.miniproject2.bookcafe.dto.SignupRequestDto;
import com.miniproject2.bookcafe.dto.UserResponseDto;
import com.miniproject2.bookcafe.repository.UserRepository;
import com.miniproject2.bookcafe.security.UserDetailsImpl;
import com.miniproject2.bookcafe.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    //회원가입
    @PostMapping("/user/signup")
    public void registerUser(@RequestBody SignupRequestDto requestDto) {
        userService.registerUser(requestDto);
    }


    @PostMapping("/user/islogin")
    public UserResponseDto islogin(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        System.out.println("username : " + user.getUsername());
        System.out.println("username : " + user.getNickname());
        return new UserResponseDto(user.getUsername(), user.getNickname());
    }
}



