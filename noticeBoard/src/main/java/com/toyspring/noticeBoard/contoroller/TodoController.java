package com.toyspring.noticeBoard.contoroller;


import com.toyspring.noticeBoard.Entity.Todo;
import com.toyspring.noticeBoard.dto.TodoPatchDto;
import com.toyspring.noticeBoard.dto.TodoPostDto;
import com.toyspring.noticeBoard.dto.TodoResponseDto;
import com.toyspring.noticeBoard.mapper.TodoMapper;
import com.toyspring.noticeBoard.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.util.List;


@RestController
@RequestMapping("/v1/todos")
public class TodoController {


    @Autowired
    private TodoService todoService;

    private TodoMapper mapper;

    public TodoController(TodoService todoService, TodoMapper mapper) {
        this.todoService = todoService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity createTodo(@RequestBody TodoPostDto postDto){
      Todo todo = mapper.todoPostDtoToTodo(postDto);

      Todo createTodo = todoService.createTodo(todo);
      TodoResponseDto responseDto = mapper.todoToTodoResponseDto(createTodo);

      System.out.println("포스트 만들어짐");
      return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{todo_id}")
    public ResponseEntity updateTodo(@Positive @PathVariable("todo_id") @Min(1) Long todoId, @RequestBody TodoPatchDto requestBody){
        requestBody.setTodoId(todoId);

        Todo updateTodo = todoService.updateTodo(mapper.todoPatchDtoToTodo(requestBody));

        return new ResponseEntity<>(mapper.todoToTodoResponseDto(updateTodo),HttpStatus.OK);
    }

    @GetMapping("/{todo_id}")
    public ResponseEntity findTodo(@Positive @PathVariable("todo_id") @Min(1) Long todoId){
        Todo todo = todoService.findByTodo(todoId);

        return new ResponseEntity(todo,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity findTodoAll(){
        List<Todo> findTodo = todoService.findTodos();

        return new ResponseEntity<>(findTodo,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{todo_id}")
    public ResponseEntity deleteTodo(@Positive @PathVariable("todo_id") Long todoId){

       todoService.deleteTodo(todoId);

       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }





}
