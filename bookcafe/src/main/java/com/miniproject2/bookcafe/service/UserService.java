package com.miniproject2.bookcafe.service;

import com.miniproject2.bookcafe.domain.User;
import com.miniproject2.bookcafe.dto.SignupRequestDto;
import com.miniproject2.bookcafe.repository.UserRepository;
import com.miniproject2.bookcafe.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public void registerUser(SignupRequestDto requestDto) {

        //중복된 이메일(로그인 id)가 존재할 경우
        String username = requestDto.getUsername();
        String nickname = requestDto.getNickname();
//        Optional<User> isDuplicatedEmail = userRepository.findByEmail(email);

        if (userRepository.existsByUsername(username)) {
            throw new IllegalArgumentException("중복된 아이디입니다.");
        }
        //중복된 닉네임이 존재할 경우
        if (userRepository.existsByNickname(nickname)) {
            throw new IllegalArgumentException("중복된 닉네임입니다.");
        }

        // 패스워드
        String enPassword = passwordEncoder.encode(requestDto.getPassword());

        User user = new User(username,nickname,enPassword);
        userRepository.save(user); // DB 저장

    }

    public User login(String username, String password) {
//        System.out.println(username);
        User user = userRepository.findByUsername(username).orElseThrow(() -> new IllegalArgumentException("아이디 찾을 수 없습니다."));

        if (!passwordEncoder.matches(password,user.getPassword() ))
        {
            throw new IllegalArgumentException("비밀번호 불일치");
        }
        return user;
    }
}
