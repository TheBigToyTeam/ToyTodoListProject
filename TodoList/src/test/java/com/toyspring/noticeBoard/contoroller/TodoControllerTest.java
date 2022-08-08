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
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class TodoControllerTest {


    @Autowired
    private MockMvc mockMvc;
    @Test
    void create() throws Exception {




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