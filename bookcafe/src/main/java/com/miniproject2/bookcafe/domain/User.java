package com.miniproject2.bookcafe.domain;

import com.miniproject2.bookcafe.dto.SignupRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false)
    private String password;

//    public User(SignupRequestDto requestDto, String enPassword) {
//        this.username = requestDto.getUsername();
//        this.nickname = requestDto.getNickname();
//        this.password = enPassword;
//    }
    public User(String username, String nickname, String enPassword) {
        this.username = username;
        this.nickname = nickname;
        this.password = enPassword;
    }
}
