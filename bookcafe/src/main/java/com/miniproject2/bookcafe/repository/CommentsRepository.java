package com.miniproject2.bookcafe.repository;

import com.miniproject2.bookcafe.domain.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments, Long> {
    List<Comments> findBymoimId(Long moimId);
}
