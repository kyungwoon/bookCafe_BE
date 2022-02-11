package com.miniproject2.bookcafe.controller;

import com.miniproject2.bookcafe.dto.SignupRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserServie userServie;

    @Autowired
    public UserController(UserServie userServie) {
        this.userServie = userServie;
    }

    @PostMapping("/user/signup")
    public void registerUser(@RequestBody SignupRequestDto requestDto){
        userService.registerUser(requestDto);
    }
}
