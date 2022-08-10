package com.toyspring.noticeBoard.contoroller;


import com.google.gson.Gson;
import com.toyspring.noticeBoard.Entity.Todo;
import com.toyspring.noticeBoard.dto.TodoDto;
import com.toyspring.noticeBoard.dto.TodoPostDto;
import com.toyspring.noticeBoard.mapper.TodoMapper;
import com.toyspring.noticeBoard.repository.TodoRepository;
import com.toyspring.noticeBoard.service.TodoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TodoControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;


    @Test
    void create() throws Exception {
        //given
        TodoDto.Create create = new TodoDto.Create("테스트용", "입니다");

        String content = gson.toJson(create);
        //when
        ResultActions actions =
                mockMvc.perform(
                        post("/v2/todos")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(content)

                );




        //then
        MvcResult result = actions
                .andExpect(status().isCreated()) // (8)
                .andReturn();  // (9)


    }

    @Test
    void update() throws Exception {
        //given
        TodoDto.Create create = new TodoDto.Create("테스트용", "입니다");
        TodoDto.Patch patch = new TodoDto.Patch(create.getTodoId(),"수정 테스트 입니다.","수정 테스트 컨텐츠 입니다", LocalDateTime.now());

        String content = gson.toJson(patch);

        //when
        ResultActions actions = mockMvc.perform(
                patch("/v1/todos/1")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)

        );

        //then
        MvcResult result = actions.andExpect(status().isOk()).andReturn();

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