package com.miniproject2.bookcafe.repository;
import com.miniproject2.bookcafe.domain.MoimMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoimMemberRepository extends JpaRepository<MoimMember, Long> {
    List<MoimMember> findAllByMoimId(Long moimId);
    MoimMember findByMoimIdAndNickname(Long moimId, String nickname);
}
