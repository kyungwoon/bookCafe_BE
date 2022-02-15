package com.miniproject2.bookcafe.dto;

import com.miniproject2.bookcafe.domain.Comment;
import com.miniproject2.bookcafe.domain.Moim;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class MoimResponseDto {
    private Long moimId;
    private String title;
    private String contents;
    private String nickname;
    private Integer personCnt;
    private String bookTitle;
    private String bookContents;
    private String joinUntil;
    private String bookUrl;
    private String imageUrl;
    private List<String> moimMembers;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private List<Comment> comments;


    public MoimResponseDto(Moim moim,List<String> moimMembers){
        this.moimId = moim.getMoimId();
        this.title = moim.getTitle();
        this.contents = moim.getContents();
        this.nickname = moim.getNickname();
        this.personCnt = moim.getPersonCnt();
        this.bookTitle = moim.getBookTitle();
        this.bookContents = moim.getBookContents();
        this.joinUntil = moim.getJoinUntil();
        this.bookUrl = moim.getBookUrl();
        this.imageUrl = moim.getImageUrl();
        this.moimMembers = moimMembers;
        this.createdAt = moim.getCreatedAt();
        this.modifiedAt = moim.getModifiedAt();
        this.comments = moim.getComments();
    }


}