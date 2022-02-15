package com.miniproject2.bookcafe.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@RequiredArgsConstructor
public class MoimMemberRequestDto {
    private final Long moimId;
    private final String nickname;

}
