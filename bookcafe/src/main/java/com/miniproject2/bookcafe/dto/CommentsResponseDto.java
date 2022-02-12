package com.miniproject2.bookcafe.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CommentsResponseDto {

    private Long commentId;
    private Long moimId;
    private String nickname;
    private String comment;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public CommentsResponseDto(Long commentId, Long moimId, LocalDateTime createdAt, LocalDateTime modifiedAt, String nickname, String comment) {
        this.commentId = commentId;
        this.moimId = moimId;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.nickname = nickname;
        this.comment = comment;
    }
}

