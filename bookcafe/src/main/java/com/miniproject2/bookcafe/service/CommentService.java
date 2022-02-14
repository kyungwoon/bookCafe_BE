package com.miniproject2.bookcafe.service;

import com.miniproject2.bookcafe.domain.Comment;
import com.miniproject2.bookcafe.dto.CommentRequestDto;
import com.miniproject2.bookcafe.dto.CommentResponseDto;
import com.miniproject2.bookcafe.repository.CommentRepository;
import com.miniproject2.bookcafe.repository.MoimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final MoimRepository moimRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, MoimRepository moimRepository) {

        this.commentRepository = commentRepository;
        this.moimRepository = moimRepository;
    }

    // Id에 해당하는 댓글 전체 get
    public List<CommentResponseDto> readComment(Long id) {
        List<Comment> comments = commentRepository.findAllByMoimId(id);
        List<CommentResponseDto> commentResponseDtos = new ArrayList<>();
        for (Comment comment : comments) {
            CommentResponseDto commentResponseDto = new CommentResponseDto(
                    comment.getCommentId(),
                    comment.getComment(),
                    comment.getCreatedAt(),
                    comment.getModifiedAt(),
                    comment.getNickname(),
                    comment.getMoimId()
            );
            commentResponseDtos.add(commentResponseDto);
        }
        return commentResponseDtos;
    }


    //댓글 작성
    public Comment writeComment(CommentRequestDto requestDto, Long moimId) {
//        Moim moim = moimRepository.findById(moimId).orElseThrow(
//                () -> new IllegalArgumentException("아이디가 존재하지 않습니다"));
        Comment comment = new Comment(requestDto, moimId);
        System.out.println(comment.getMoimId());
        commentRepository.save(comment);
        return comment;
    }

    //댓글 삭제
    @Transactional
    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                ()-> new IllegalArgumentException("게시물이 존재하지 않습니다")
        );
        commentRepository.delete(comment);
    }

    //수정 하기
    @Transactional
    public  CommentResponseDto editComment(CommentRequestDto commentRequestDto, long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                ()-> new IllegalArgumentException("")
        );
        comment.setComment(commentRequestDto.getComment());
        commentRepository.save(comment);

        return new CommentResponseDto(
                comment.getCommentId(),
                comment.getComment(),
                comment.getCreatedAt(),
                comment.getModifiedAt(),
                comment.getNickname(),
                comment.getMoimId()
        );
    }
}

