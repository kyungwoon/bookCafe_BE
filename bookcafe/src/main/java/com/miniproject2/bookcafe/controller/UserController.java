package com.miniproject2.bookcafe.controller;

import com.miniproject2.bookcafe.domain.User;
import com.miniproject2.bookcafe.dto.SignupRequestDto;
import com.miniproject2.bookcafe.dto.UserResponseDto;
import com.miniproject2.bookcafe.repository.UserRepository;
import com.miniproject2.bookcafe.security.UserDetailsImpl;
import com.miniproject2.bookcafe.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class
UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    //회원가입
    @PostMapping("/user/signup")
    public void registerUser(@RequestBody SignupRequestDto requestDto) {
        userService.registerUser(requestDto);
    }


    @PostMapping("/islogin")
    public UserResponseDto islogin(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        System.out.println("username : " + user.getUsername());
        System.out.println("nickname : " + user.getNickname());
        return new UserResponseDto(user.getUsername(), user.getNickname());
    }


    // 모임 삭제하기
    @DeleteMapping("/user/{userId}")
    public Long deletUser(@PathVariable Long userId){
        User user =  userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("모임이 존재하지 않습니다. ")
        );
        userRepository.deleteById(userId);
        return userId;
    }
}



