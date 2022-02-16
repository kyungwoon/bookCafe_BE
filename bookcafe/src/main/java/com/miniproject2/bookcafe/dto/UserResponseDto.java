package com.miniproject2.bookcafe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class UserResponseDto {
    private String username;
    private String nickname;

}