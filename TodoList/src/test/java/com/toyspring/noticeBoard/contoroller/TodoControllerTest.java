package com.toyspring.noticeBoard.contoroller;


import com.toyspring.noticeBoard.Entity.Todo;
import com.toyspring.noticeBoard.dto.TodoDto;
import com.toyspring.noticeBoard.dto.TodoPostDto;
import com.toyspring.noticeBoard.mapper.TodoMapper;
import com.toyspring.noticeBoard.repository.TodoRepository;
import com.toyspring.noticeBoard.service.TodoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class TodoControllerTest {

    @Autowired
    private TodoService todoService;

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private TodoMapper todoMapper;


    @Test
    void create() throws Exception {

//        //given
//        TodoPostDto postDto = new TodoPostDto();
//
//        postDto.setTitle("테스트 입니다.");
//        postDto.setContent("테스트 콘텐츠 입니다.");
//
//        Todo todoContent = todoMapper.todoPostDtoToTodo(postDto);
//
//        System.out.println("todoContent = " + todoContent);
//
//        //when
//        Todo mock = todoService.newWrite(new TodoDto.Create("테스트 입니다.", "테스트 콘텐츠 입니다."));
//        Todo todo = mock;
//
//
//        //then
//        Assertions.assertThat(todoContent).isEqualTo(todoService.newWrite(Mock));




    }

    @Test
    void update() {
    }

    @Test
    void findTodo() {
    }

    @Test
    void readAll() {
    }

    @Test
    void delete() {
    }
}