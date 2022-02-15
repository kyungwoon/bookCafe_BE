package com.miniproject2.bookcafe.dto;

import com.miniproject2.bookcafe.domain.User;
import com.miniproject2.bookcafe.security.UserDetailsImpl;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserResponseDto {
    private String username;
    private String nickname;


    public UserResponseDto(String username, String nickname){
        this.username = username;
        this.nickname = nickname;
    }
}