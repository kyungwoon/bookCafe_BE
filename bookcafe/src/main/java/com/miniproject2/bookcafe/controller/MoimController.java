package com.miniproject2.bookcafe.controller;

import com.miniproject2.bookcafe.domain.Moim;
import com.miniproject2.bookcafe.domain.MoimMember;
import com.miniproject2.bookcafe.domain.User;
import com.miniproject2.bookcafe.dto.MoimMemberRequestDto;
import com.miniproject2.bookcafe.dto.MoimRequestDto;
import com.miniproject2.bookcafe.dto.MoimResponseDto;
import com.miniproject2.bookcafe.dto.UserRequestDto;
import com.miniproject2.bookcafe.repository.MoimMemberRepository;
import com.miniproject2.bookcafe.repository.MoimRepository;
import com.miniproject2.bookcafe.repository.UserRepository;
import com.miniproject2.bookcafe.service.MoimService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class MoimController {

    private final MoimRepository moimRepository;
    private final MoimService moimService;
    private final MoimMemberRepository moimMemberRepository;
    private final UserRepository userRepository;

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
        Moim moim = moimRepository.findById(requestDto.getMoimId()).orElseThrow(
                () -> new IllegalArgumentException("모임이 존재하지 않습니다.")
        );
        User user = userRepository.findByNickname(requestDto.getNickname());
        MoimMember moimMember = new MoimMember(moim, user);
        moimMemberRepository.save(moimMember);
        return null;
    }


    // 모임 참가 취소하기
    @DeleteMapping("/moims/join")
    public String deleteMoimMember(@RequestBody MoimMemberRequestDto requestDto){
        Moim moim = moimRepository.findById(requestDto.getMoimId()).orElseThrow(
                () -> new IllegalArgumentException("모임이 존재하지 않습니다.")
        );

        List<MoimMember>moimMembers = moim.getMoimMembers();

        for(MoimMember moimMember : moimMembers){
            String deleteNickname = requestDto.getNickname();
            String targetNickname = moimMember.getUser().getNickname();
            if(deleteNickname.equals(targetNickname)){
                System.out.println(deleteNickname);
                System.out.println(targetNickname);
                moimMemberRepository.deleteById(moimMember.getMemberId());
                return "참가 취소 성공";
            }
        }
        return "모임 참가 취소 성공";
    }


    // 유저가 참가 신청한 모임 조회하기
    @GetMapping("/moims/user")
    public List<MoimResponseDto> getUserMoims(@RequestBody UserRequestDto requestDto){
        return moimService.getUserMoims(requestDto);
    }
}



