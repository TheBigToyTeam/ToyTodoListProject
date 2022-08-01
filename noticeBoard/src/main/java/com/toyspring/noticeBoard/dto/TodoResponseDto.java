package com.toyspring.noticeBoard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.reflect.Member;

@Getter
@AllArgsConstructor
public class TodoResponseDto {

    private Long TodoId;
    private String content;
    private String title;
}
