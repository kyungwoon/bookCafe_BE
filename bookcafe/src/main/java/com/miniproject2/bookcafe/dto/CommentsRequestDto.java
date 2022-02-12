package com.miniproject2.bookcafe.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class CommentsRequestDto {

    private String comment;

    public CommentsRequestDto(String comment) {
        this.comment = comment;
    }
}
