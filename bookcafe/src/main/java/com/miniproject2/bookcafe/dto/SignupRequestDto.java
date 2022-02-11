package com.miniproject2.bookcafe.dto;

import lombok.Getter;

@Getter
public class SignupRequestDto {
    private String nickname;
    private String password;
    private String email;
}
