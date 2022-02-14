package com.miniproject2.bookcafe.domain;

import com.miniproject2.bookcafe.dto.CommentRequestDto;

import com.miniproject2.bookcafe.dto.CommentResponseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Comment extends Timestamped{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long commentId;

    @Column(nullable = false)
    private Long moimId;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String comment;

    public Comment(CommentRequestDto commentRequestDto, Long moimId) {
        this.comment = commentRequestDto.getComment();
        this.nickname = commentRequestDto.getNickname();
//        this.commentId = commentRequestDto.getCommentId();
        this.moimId = moimId;
    }

    public Comment(CommentResponseDto commentResponseDto) {
        this.comment = commentResponseDto.getComment();
        this.nickname = commentResponseDto.getNickname();
        this.commentId = commentResponseDto.getCommentId();
        this.moimId = commentResponseDto.getMoimId();
    }
}
