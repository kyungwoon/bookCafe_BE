package com.miniproject2.bookcafe.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CommentResponseDto {

    private Long commentId;
    private String nickname;
    private String comment;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Long moimId;


    public CommentResponseDto(Long commentId, String comment, LocalDateTime createdAt, LocalDateTime modifiedAt, String nickname, Long moimId) {
        this.commentId = commentId;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.nickname = nickname;
        this.comment = comment;
        this.moimId = moimId;
    }
}
