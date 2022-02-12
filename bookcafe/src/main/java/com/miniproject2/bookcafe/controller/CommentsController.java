package com.miniproject2.bookcafe.controller;

import com.miniproject2.bookcafe.dto.CommentsRequestDto;
import com.miniproject2.bookcafe.dto.CommentsResponseDto;
import com.miniproject2.bookcafe.service.CommentsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentsController {

    public CommentsService commentsService;
    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    // 댓글 불러오기
    @GetMapping("/comments/{moimId}")
    public List<CommentsResponseDto> readComments(@PathVariable Long moimId) {

        return commentsService.readComments(n);
    }

    //댓글 작성성
    @PostMapping("/comments/{moimId}")
    public void writeComment(@PathVariable Long moimId, @RequestBody CommentsRequestDto commentsRequestDto ) {
        // 로그인 되어 있는 ID
        commentsService.writeComment(commentsRequestDto, moimId);

    }

    //댓글 삭제
    @DeleteMapping("/comments/{commentId}")
    public void deleteComment(@PathVariable Long commentId) {

        commentsService.deleteComment(commentId);
    }

    //수정 하기
    @PutMapping("/comments/{commentId}")
    public void editComment(@RequestBody CommentsRequestDto commentsRequestDto, @PathVariable Long commentId) {
        if(userDetails==null){
            throw new IllegalArgumentException("로그인을 해야 댓글을 수정할 수 있습니다.");
        }
        commentsService.editComments(commentsRequestDto, commentId);

    }
}

