package com.miniproject2.bookcafe.domain;


import com.miniproject2.bookcafe.dto.CommentsRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Comments {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long commentId;
    private Long moimId;

    @Column(nullable = false)
    private String nickname;
    @Column(nullable = false)
    private String comment;
    @Column
    private LocalDateTime createdAt;
    @Column
    private LocalDateTime modifiedAt;

    public Comment(CommentsRequestDto commentsRequestDto, Nickname nickname, CommentId commentId, MoimId moimId) {
        this.comment = commentsRequestDto.getComment();
        this.nickname = nickname;
        this.commentId = commentId;
        this.moimId = moimId;
    }
}
