package com.miniproject2.bookcafe.service;

import com.miniproject2.bookcafe.domain.User;
import com.miniproject2.bookcafe.dto.SignupRequestDto;
import com.miniproject2.bookcafe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void registerUser(SignupRequestDto requestDto) {

        //중복된 이메일(로그인 id)가 존재할 경우
        String email = requestDto.getEmail();
        String nickname = requestDto.getNickname();
//        Optional<User> isDuplicatedEmail = userRepository.findByEmail(email);

        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("중복된 아이디입니다.");
        }
        //중복된 닉네임이 존재할 경우
        if (userRepository.existsByNickname(nickname)) {
            throw new IllegalArgumentException("중복된 닉네임입니다.");
        }

        // 패스워드
        String enPassword = passwordEncoder.encode(requestDto.getPassword());

        User user = new User(requestDto, enPassword);
        userRepository.save(user); // DB 저장
    }
}
