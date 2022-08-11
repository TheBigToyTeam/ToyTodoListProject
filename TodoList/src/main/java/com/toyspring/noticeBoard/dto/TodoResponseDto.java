package com.toyspring.noticeBoard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.lang.reflect.Member;

@Getter
@AllArgsConstructor
public class TodoResponseDto {

    private Long TodoId;

    @NotBlank(message = "타이틀은 공백일 수 없습니다.")
    private String title;

    @NotBlank(message = "내용은 공백일 수 없습니다.")
    private String contents;
}
