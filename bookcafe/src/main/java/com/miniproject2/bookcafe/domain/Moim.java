package com.miniproject2.bookcafe.domain;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.miniproject2.bookcafe.dto.MoimRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
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

//  https://bcp0109.tistory.com/332 : 양방향 참조 엔티티 삭제 방법
    @JsonManagedReference
    @OneToMany(mappedBy = "moim", orphanRemoval = true)
    List<Comment> comments;

    @JsonManagedReference
    @OneToMany(mappedBy = "moim", orphanRemoval = true)
    List<MoimMember> moimMembers;

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
