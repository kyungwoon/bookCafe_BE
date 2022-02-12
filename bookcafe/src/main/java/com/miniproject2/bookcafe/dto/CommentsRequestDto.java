package com.miniproject2.bookcafe.dto;
<<<<<<< HEAD
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
=======

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
>>>>>>> b4aae65b5d142d90994e5033206059d775e6ef04
public class CommentsRequestDto {

    private Long commentId;
    private Long moimId;
    private String nickname;
    private String comment;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public CommentsRequestDto(Long commentId, Long moimId, LocalDateTime createdAt, LocalDateTime modifiedAt, String nickname, String comment) {
        this.commentId = commentId;
        this.moimId = moimId;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.nickname = nickname;
        this.comment = comment;
    }
}
