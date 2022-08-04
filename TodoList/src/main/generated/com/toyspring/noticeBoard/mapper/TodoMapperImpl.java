package com.toyspring.noticeBoard.mapper;

import com.toyspring.noticeBoard.Entity.Todo;
import com.toyspring.noticeBoard.dto.TodoPatchDto;
import com.toyspring.noticeBoard.dto.TodoPostDto;
import com.toyspring.noticeBoard.dto.TodoResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-04T19:29:08+0900",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 11.0.15 (Azul Systems, Inc.)"
)
@Component
public class TodoMapperImpl implements TodoMapper {

    @Override
    public Todo todoPostDtoToTodo(TodoPostDto todoPostDto) {
        if ( todoPostDto == null ) {
            return null;
        }

        Todo todo = new Todo();

        todo.setTitle( todoPostDto.getTitle() );
        todo.setContent( todoPostDto.getContent() );

        return todo;
    }

    @Override
    public Todo todoPatchDtoToTodo(TodoPatchDto todoPatchDto) {
        if ( todoPatchDto == null ) {
            return null;
        }

        Todo todo = new Todo();

        todo.setTodoId( todoPatchDto.getTodoId() );
        todo.setTitle( todoPatchDto.getTitle() );
        todo.setContent( todoPatchDto.getContent() );
        todo.setModifiedAt( todoPatchDto.getModifiedAt() );

        return todo;
    }

    @Override
    public TodoResponseDto todoToTodoResponseDto(Todo todo) {
        if ( todo == null ) {
            return null;
        }

        String title = null;
        String content = null;

        title = todo.getTitle();
        content = todo.getContent();

        Long todoId = null;

        TodoResponseDto todoResponseDto = new TodoResponseDto( todoId, title, content );

        return todoResponseDto;
    }
}
