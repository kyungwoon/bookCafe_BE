package com.miniproject2.bookcafe.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "MOIM_ID")
    private Moim moim;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public MoimMember(Moim moim, User user){
        this.moim = moim;
        this.user = user;
    }
}