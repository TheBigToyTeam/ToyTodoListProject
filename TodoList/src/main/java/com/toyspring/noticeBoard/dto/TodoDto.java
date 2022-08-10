package com.toyspring.noticeBoard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
@Getter
public class TodoDto {

    private Long todoId;

    @Getter
    public static class Create{

        private Long todoId;
        @NotBlank(message = "타이틀은 공백일 수 없습니다.")
        private String title;

        @NotBlank(message = "내용은 공백일 수 없습니다.")
        private String content;


        public Create(String title, String content) {
            this.title = title;
            this.content = content;
        }
    }

    @AllArgsConstructor
    @Getter
    public static class Patch{

        private Long todoId;

        @NotBlank(message = "타이틀은 공백일 수 없습니다.")
        private String title;

        @NotBlank(message = "내용은 공백일 수 없습니다.")
        private String content;
        private LocalDateTime modifiedAt = LocalDateTime.now();

        public void setMemberId(long todoId) {
            this.todoId = todoId;
        }
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

