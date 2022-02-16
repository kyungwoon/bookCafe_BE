package com.miniproject2.bookcafe.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.miniproject2.bookcafe.dto.CommentRequestDto;
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
    private String nickname;

    @Column(nullable = false)
    private String comment;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "MOIM_ID")
    private Moim moim;

    public Comment(CommentRequestDto commentRequestDto, Moim moim) {
        this.comment = commentRequestDto.getComment();
        this.nickname = commentRequestDto.getNickname();
        this.moim = moim;
    }
}
