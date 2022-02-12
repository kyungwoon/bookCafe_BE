package com.miniproject2.bookcafe.domain;


import com.miniproject2.bookcafe.dto.MoimRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Moim extends Timestamped {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long moimId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private Integer personCnt;

    @Column(nullable = false)
    private String bookTitle;

    @Column(nullable = false)
    private String bookContents;

    @Column(nullable = false)
    private String joinUntil;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private String bookUrl;

    public Moim(MoimRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.nickname = requestDto.getNickname();
        this.personCnt = requestDto.getPersonCnt();
        this.bookTitle = requestDto.getBookTitle();
        this.bookContents = requestDto.getBookContents();
        this.joinUntil = requestDto.getJoinUntil();
        this.bookUrl = requestDto.getBookUrl();
        this.imageUrl = requestDto.getImageUrl();
    }


    public void update(MoimRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.nickname = requestDto.getNickname();
        this.personCnt = requestDto.getPersonCnt();
        this.bookTitle = requestDto.getBookTitle();
        this.bookContents = requestDto.getBookContents();
        this.joinUntil = requestDto.getJoinUntil();
        this.bookUrl = requestDto.getBookUrl();
        this.imageUrl = requestDto.getImageUrl();
    }

}
