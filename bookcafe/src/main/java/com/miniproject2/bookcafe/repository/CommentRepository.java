package com.miniproject2.bookcafe.repository;

import com.miniproject2.bookcafe.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
