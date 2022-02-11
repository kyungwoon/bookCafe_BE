package com.miniproject2.bookcafe.repository;

import com.miniproject2.bookcafe.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // 이메일(로그인 id) 존재 여부
    boolean existsByEmail(String email);
//    Optional<User> findByEmail(String email);

    boolean existsByNickname(String nickname);
}
