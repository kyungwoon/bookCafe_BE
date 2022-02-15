package com.miniproject2.bookcafe.controller;

import com.miniproject2.bookcafe.domain.Comment;
import com.miniproject2.bookcafe.domain.Moim;
import com.miniproject2.bookcafe.domain.MoimMember;
import com.miniproject2.bookcafe.dto.MoimMemberRequestDto;
import com.miniproject2.bookcafe.dto.MoimRequestDto;
import com.miniproject2.bookcafe.dto.MoimResponseDto;
import com.miniproject2.bookcafe.repository.CommentRepository;
import com.miniproject2.bookcafe.repository.MoimMemberRepository;
import com.miniproject2.bookcafe.repository.MoimRepository;
import com.miniproject2.bookcafe.service.MoimService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MoimController {

    private final MoimRepository moimRepository;
    private final MoimService moimService;
    private final MoimMemberRepository moimMemberRepository;
    private final CommentRepository commentRepository;

    // 모임 생성하기
    @PostMapping("/moims")
    public Moim createMoim(@RequestBody MoimRequestDto requestDto){
        Moim moim = new Moim(requestDto);
        return moimService.createMoim(moim);
    }

    // 모임 삭제하기
    @DeleteMapping("/moims/{moimId}")
    public Long deletMoim(@PathVariable Long moimId){
        Moim moim =  moimRepository.findById(moimId).orElseThrow(
                () -> new IllegalArgumentException("모임이 존재하지 않습니다. ")
        );
        moimRepository.deleteById(moimId);
        return moimId;
    }

    // 모임 불러오기 (response DTO 작업해야 함)
    @GetMapping("/moims")
    public List<MoimResponseDto> getMoims(){
        return moimService.getMoims();
    }

    // 상세 페이지 모임 불러오기
    @GetMapping("/moims/{moimId}")
    public MoimResponseDto getMoimDetails(@PathVariable Long moimId){
        return moimService.getMoimDetails(moimId);
    }

    // 모임 내용 수정하기
    @PutMapping("/moims/{moimId}")
    public Moim updateMoim(@PathVariable Long moimId,
                           @RequestBody MoimRequestDto requestDto){
        moimService.update(moimId, requestDto);
        return null;
    }

    // 모임 참가하기
    @PostMapping("/moims/join")
    public Moim participateMoim(@RequestBody MoimMemberRequestDto requestDto){
        MoimMember moimMember = new MoimMember(requestDto);
        moimMemberRepository.save(moimMember);
        return null;
    }


    // 모임 참가 취소하기
    @DeleteMapping("/moims/join")
    public Moim deleteMoimMember(@RequestBody MoimMemberRequestDto requestDto){
        MoimMember moimMember =
                moimMemberRepository.findByMoimIdAndNickname(
                        requestDto.getMoimId(), requestDto.getNickname());
        if(moimMember == null){
            throw new IllegalArgumentException("모임에 참가하지 않았습니다.");
        }

        Long memberId = moimMember.getMemberId();
        moimMemberRepository.deleteById(memberId);
        return null;
    }

}



