package com.miniproject2.bookcafe.domain;

import com.miniproject2.bookcafe.dto.MoimMemberRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@Getter
@Entity
public class MoimMember{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long memberId;

    @Column
    private Long moimId;

    @Column(nullable = false)
    private String nickname;

    public MoimMember(MoimMemberRequestDto requestDto){
        this.moimId = requestDto.getMoimId();
        this.nickname = requestDto.getNickname();
    }
}