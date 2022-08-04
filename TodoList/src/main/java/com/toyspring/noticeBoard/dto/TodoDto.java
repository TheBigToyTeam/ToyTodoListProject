package com.toyspring.noticeBoard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class TodoDto {

    @AllArgsConstructor
    @Getter
    public static class Create{
        @NotBlank(message = "타이틀은 공백일 수 없습니다.")
        private String title;

        @NotBlank(message = "내용은 공백일 수 없습니다.")
        private String content;
    }

    @AllArgsConstructor
    @Getter
    public static class Patch{

        private Long TodoId;

        @NotBlank(message = "타이틀은 공백일 수 없습니다.")
        private String title;

        @NotBlank(message = "내용은 공백일 수 없습니다.")
        private String content;
        private LocalDateTime modifiedAt = LocalDateTime.now();
    }

    @AllArgsConstructor
    @Getter
    public static class Response{

        private Long TodoId;

        @NotBlank(message = "타이틀은 공백일 수 없습니다.")
        private String title;

        @NotBlank(message = "내용은 공백일 수 없습니다.")
        private String content;
    }


}

