package com.toyspring.noticeBoard.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Data
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoId;


    private String title;
    private String contents;
    private LocalDateTime createAt = LocalDateTime.now();
    private LocalDateTime modifiedAt = LocalDateTime.now();
}
