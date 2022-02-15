package com.miniproject2.bookcafe.service;

import com.miniproject2.bookcafe.domain.Comment;
import com.miniproject2.bookcafe.domain.Moim;
import com.miniproject2.bookcafe.dto.CommentRequestDto;
import com.miniproject2.bookcafe.dto.CommentResponseDto;
import com.miniproject2.bookcafe.repository.CommentRepository;
import com.miniproject2.bookcafe.repository.MoimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final MoimRepository moimRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, MoimRepository moimRepository) {

        this.commentRepository = commentRepository;
        this.moimRepository = moimRepository;
    }

    //댓글 작성
    public String writeComment(CommentRequestDto requestDto, Long moimId) {
        Moim moim = moimRepository.findById(moimId).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다"));

        Comment comment = new Comment(requestDto, moim);
        commentRepository.save(comment);
        return requestDto.getComment();
    }


    // Id에 해당하는 댓글 전체 get
    public List<CommentResponseDto> readComment(Long moimId) {
//        List<Comment> comments = commentRepository.findAllByMoimId(moimId);
        List<CommentResponseDto> commentResponseDtos = new ArrayList<>();

        Moim moim= moimRepository.findById(moimId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 모임입니다."));
        List<Comment> comments = moim.getComments();

        for (Comment comment : comments) {
                    CommentResponseDto commentResponseDto =
                            new CommentResponseDto(comment);
            commentResponseDtos.add(commentResponseDto);
        }

//       https://zangzangs.tistory.com/60 : DTO 정렬하기
        return commentResponseDtos.stream().
                sorted(Comparator.comparing(CommentResponseDto::getCreatedAt).reversed()).
                collect(Collectors.toList());
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
    public  Comment editComment(CommentRequestDto commentRequestDto, long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                ()-> new IllegalArgumentException("코멘트를 찾을 수 없습니다.")
        );
        comment.setComment(commentRequestDto.getComment());
        commentRepository.save(comment);

        return comment;
    }
}

