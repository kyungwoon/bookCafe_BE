package com.miniproject2.bookcafe.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class MoimRequestDto {
    private final String title;
    private final String contents;
    private final String nickname;
    private final Integer personCnt;
    private final String bookTitle;
    private final String bookContents;
    private final String joinUntil;
    private final String bookUrl;
    private final String imageUrl;
}