package com.miniproject2.bookcafe.controller;


import com.miniproject2.bookcafe.domain.Comment;
import com.miniproject2.bookcafe.dto.CommentRequestDto;
import com.miniproject2.bookcafe.dto.CommentResponseDto;
import com.miniproject2.bookcafe.repository.CommentRepository;
import com.miniproject2.bookcafe.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {

    public final CommentService commentService;
    public final CommentRepository commentRepository;

    //댓글 작성
    @PostMapping("/comments/{moimId}")
    public String writeComment(@PathVariable Long moimId, @RequestBody CommentRequestDto commentRequestDto ) {
        return commentService.writeComment(commentRequestDto, moimId);
    }


    // 댓글 조회
    @GetMapping("/comments/{moimId}")
    public List<CommentResponseDto> readComment(@PathVariable Long moimId) {
        return commentService.readComment(moimId);
    }


    //댓글 삭제
    @DeleteMapping("/comments/{commentId}")
    public void deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
    }

    //수정 하기
    @PutMapping("/comments/{commentId}")
    public Comment  editComment(@RequestBody CommentRequestDto commentRequestDto, @PathVariable Long commentId) {
       return  commentService.editComment(commentRequestDto, commentId);
    }
}


