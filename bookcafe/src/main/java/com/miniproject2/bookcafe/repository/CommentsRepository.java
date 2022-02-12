package com.miniproject2.bookcafe.repository;

import com.miniproject2.bookcafe.domain.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments, Long> {
    List<Comments> findAllByMoimId(Long moimId);
}
