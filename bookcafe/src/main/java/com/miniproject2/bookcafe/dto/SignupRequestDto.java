package com.miniproject2.bookcafe.dto;

import lombok.Getter;

@Getter
public class SignupRequestDto {
    private String username;
    private String nickname;
    private String password;
    private String checkPassword;
}
