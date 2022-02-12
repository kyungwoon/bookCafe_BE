package com.miniproject2.bookcafe.service;

import com.miniproject2.bookcafe.domain.Comments;
import com.miniproject2.bookcafe.dto.CommentsRequestDto;
import com.miniproject2.bookcafe.dto.CommentsResponseDto;
import com.miniproject2.bookcafe.repository.CommentsRepository;
import jdk.javadoc.internal.doclets.formats.html.Contents;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentsService {
    private final CommentsRepository commentsRepository;

    public CommentsService(CommentsRepository CommentsRepository, com.miniproject2.bookcafe.repository.CommentsRepository commentsRepository){

        this.commentsRepository = commentsRepository;
    }
    // Id에 해당하는 댓글 전체 get
    public List<CommentsRequestDto> readComments(Long moimId) {
        List<Comments> comments = commentsRepository.findByContentsId(moimId);
        List<CommentsRequestDto> commentResponseDtos = new ArrayList<>();

        for (Comments comment : comments) {
            CommentsRequestDto commentsRequestDto = new commentsRequestDto(
                    comment.getMoimId(),
                    comment.getComment(),
                    comment.getCreatedAt(),
                    comment.getModifiedAt(),
                    comment.getNickname().getNickname()
            );
            commentsRequestDto.add(commentsRequestDto);
        }

        return commentsRequestDto;
    }

    // 댓글 작성
    @Transactional
    public void writeComment(CommentsRequestDto commentRequestDto, Long commentsId, Comments comments, Nickname nickname ) {
        Contents contents = contentsRepository.findById(commentsId).orElseThrow(
                ()-> new IllegalArgumentException("게시물이 존재하지 않습니다.")
        );
        Comments comment = new Comments(commentRequestDto,commentsId,nickname);
        commentsRepository.save(comment);

    }

    public void deleteComment(Long commentId, MoimIdId moimIdId) {
        Comments comments = commentsRepository.findById(commentId).orElseThrow(
                ()-> new IllegalArgumentException("게시물이 존재하지 않습니다.")
        );
        if(!comments.getNickname().commentsId().equals(moimIdId.getMoimIdId())){
            throw new IllegalArgumentException("로그인 한 사용자와, 댓글 작성자가 다릅니다.");
        }
        commentsRepository.delete(comments);
    }

    public CommentsRequestDto editComment(CommentsRequestDto commentRequestDto, Long commentId, MoimId moimId) {

        Comments comments = commentsRepository.findById(commentId).orElseThrow(
                ()-> new IllegalArgumentException("댓글이 존재하지 않습니다.")
        );
        if(!comments.getMoimId().getcommentId().equals(commentId.MoimId())){
            throw new IllegalArgumentException("로그인 한 사용자와, 댓글 작성자가 다릅니다.");
        }
        comments.setComment(commentRequestDto.getComment());
        commentsRepository.save(comments);

        return new CommentsRequestDto(
                comments.getMoimId(),
                comments.getCommentId(),
                comments.getCreatedAt(),
                comments.getModifiedAt(),
                comments.getMoimId().getNickname()
        );
    }
//----------------------------------------------------------------------
    private final CommentsRepository commentsRepository;


    public CommentsService(CommentsRepository commentsRepository){
        this.CommentsRepository = commentsRepository;
    }
    // Id에 해당하는 댓글 전체 get
    public List<CommentsResponseDto> readComments(Long id) {
        List<Comments> comments = commentsRepository.findByContentsId(id);
        List<CommentsResponseDto> commentResponseDtos = new ArrayList<>();

        for (Comments comment : comments) {
            CommentsResponseDto commentResponseDto = new CommentsResponseDto(
                    comment.getId(),
                    comment.getComment(),
                    comment.getCreatedAt(),
                    comment.getModifiedAt(),
                    comment.getUser().getUsername()
            );
            commentResponseDtos.add(commentResponseDto);
        }

        return commentResponseDtos;
    }

    // 댓글 작성
    @Transactional
    public void writeComment(CommentsRequestDto commentRequestDto, Long id, User user) {
        Contents contents = contentsRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("게시물이 존재하지 않습니다.")
        );
        Comments comment = new Comments(commentsRequestDto,contents, user);
        commentsRepository.save(comment);

    }

    public void deleteComment(Long commentId, User user) {
        Comments comments = commentsRepository.findById(commentId).orElseThrow(
                ()-> new IllegalArgumentException("게시물이 존재하지 않습니다.")
        );
        if(!comments.getUser().getId().equals(user.getId())){
            throw new IllegalArgumentException("로그인 한 사용자와, 댓글 작성자가 다릅니다.");
        }
        commentsRepository.delete(comments);
    }

    public CommentsResponseDto editComment(CommentsRequestDto commentRequestDto, Long commentId, User user) {

        Comments comments = commentsRepository.findById(commentId).orElseThrow(
                ()-> new IllegalArgumentException("댓글이 존재하지 않습니다.")
        );
        if(!comments.getUser().getId().equals(user.getId())){
            throw new IllegalArgumentException("로그인 한 사용자와, 댓글 작성자가 다릅니다.");
        }
        comments.setComment(commentRequestDto.getComment());
        commentsRepository.save(comments);

        return new CommentsResponseDto(
                comments.getId(),
                comments.getComment(),
                comments.getCreatedAt(),
                comments.getModifiedAt(),
                comments.getUser().getUsername()
        );
    }
}