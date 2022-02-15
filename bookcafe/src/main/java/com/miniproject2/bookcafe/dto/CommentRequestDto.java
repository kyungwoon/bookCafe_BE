package com.miniproject2.bookcafe.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class CommentRequestDto {

    private Long commentId;
    private String nickname;
    private String comment;
    private Long moimId;

    public CommentRequestDto(Long commentId, String comment, String nickname, Long moimId) {
        this.commentId = commentId;
        this.nickname = nickname;
        this.comment = comment;
        this.moimId = moimId;
    }
}
