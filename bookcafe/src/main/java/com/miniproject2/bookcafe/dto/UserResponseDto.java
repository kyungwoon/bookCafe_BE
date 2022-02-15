package com.miniproject2.bookcafe.dto;

import lombok.AllArgsConstructor;



import com.miniproject2.bookcafe.domain.User;
import com.miniproject2.bookcafe.security.UserDetailsImpl;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class UserResponseDto {
    private String username;
    private String nickname;


//    public UserResponseDto(String userDetail){
//        this.username = userDetail.getUsername();
//        this.nickname = userDetail.getNickname();
//    }

    public UserResponseDto(String username, String nickname){
        this.username = username;
        this.nickname = nickname;
    }

}