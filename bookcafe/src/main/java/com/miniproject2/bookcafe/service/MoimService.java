package com.miniproject2.bookcafe.service;

import com.miniproject2.bookcafe.domain.Moim;
import com.miniproject2.bookcafe.domain.MoimMember;
import com.miniproject2.bookcafe.dto.MoimRequestDto;
import com.miniproject2.bookcafe.dto.MoimResponseDto;
import com.miniproject2.bookcafe.repository.MoimMemberRepository;
import com.miniproject2.bookcafe.repository.MoimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class MoimService {

    private final MoimRepository moimRepository;
    private final MoimMemberRepository moimMemberRepository;

    @Autowired
    public MoimService(MoimRepository moimRepository,
                       MoimMemberRepository moimMemberRepository){
        this.moimRepository = moimRepository;
        this.moimMemberRepository = moimMemberRepository;
    }

    public Moim createMoim(Moim moim){
        moimRepository.save(moim);
        return moim;
    }

    public List<MoimResponseDto> getMoims(){
        List<Moim> moimList= moimRepository.findAllByOrderByCreatedAtDesc();
        List<MoimResponseDto> moimResponseDtos = new ArrayList<>();

        for(Moim moim : moimList) {
            List<MoimMember> moimMemberList = moim.getMoimMembers();
            if (moimMemberList != null) {
                List<String> joinMembers = new ArrayList<>();
                for (MoimMember moimMember : moimMemberList) {
                    joinMembers.add(moimMember.getUser().getNickname());
                }
                MoimResponseDto moimResponseDto =
                        new MoimResponseDto(moim, joinMembers);
                moimResponseDtos.add(moimResponseDto);
            }
        }
        return moimResponseDtos;
    }


    @Transactional
    public Long update(Long moimId, MoimRequestDto requestDto){
        Moim moim =  moimRepository.findById(moimId).orElseThrow(
                () -> new IllegalArgumentException("모임이 존재하지 않습니다.")
        );
        moim.update(requestDto);
        return moimId;
    }



    public MoimResponseDto getMoimDetails(Long moimId) {
//        List<Moim> moim= moimRepository.findAllById(Collections.singleton(moimId));
//
//        if(moim.size() == 0){
//            throw new IllegalArgumentException("모임이 존재하지 않습니다.");
//        }

        Moim moim = moimRepository.findById(moimId).orElseThrow(
                () -> new IllegalArgumentException("모임이 존재하지 않습니다.")
        );

        List<MoimMember> moimMemberList = moim.getMoimMembers();
//        List<MoimMember> moimMemberList = moimMemberRepository.findAllByMoim(moim);

        List<String> joinMembers = new ArrayList<>();
        for(MoimMember moimMember : moimMemberList){
            joinMembers.add(moimMember.getUser().getNickname());
        }
        return new MoimResponseDto(moim, joinMembers);
    }


}
