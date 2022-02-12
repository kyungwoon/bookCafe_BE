package com.miniproject2.bookcafe.dto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CommentsRequestDto {
    private Long commentId;
    private Long moinID;
    private String nickname;
    private String comment;
}
