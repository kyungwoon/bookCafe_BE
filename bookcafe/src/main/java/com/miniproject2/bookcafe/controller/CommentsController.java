package com.miniproject2.bookcafe.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class CommentsController {

    public CommentService commentService;
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // 댓글 불러오기
    @GetMapping("/comments/{moimId}")
    public List<CommentResponseDto> readComments(@PathVariable Long id) {

        return commentService.readComments(n);
    }

    //댓글 작성성
   @PostMapping("/comments/{moimId}")
    public void writeComment(@PathVariable Long id, @RequestBody CommentRequestDto commentRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        // 로그인 되어 있는 ID
        commentService.writeComment(commentRequestDto, id, userDetails.getUser());

    }

    //댓글 삭제
    @DeleteMapping("/comments/{commentId}")
    public void deleteComment(@PathVariable Long commentId, @AuthenticationPrincipal UserDetailsImpl userDetails) {

        commentService.deleteComment(commentId, userDetails.getUser());
    }

    //수정 하기
    @PutMapping("/comments/{commentId}")
    public void editComment(@RequestBody CommentRequestDto commentRequestDto,
                            @PathVariable Long commentId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if(userDetails==null){
            throw new IllegalArgumentException("로그인을 해야 댓글을 수정할 수 있습니다.");
        }
        commentService.editComment(commentRequestDto, commentId, userDetails.getUser());

    }
}

