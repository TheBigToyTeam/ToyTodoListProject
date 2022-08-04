package com.toyspring.noticeBoard.contoroller;


import com.toyspring.noticeBoard.Entity.Todo;
import com.toyspring.noticeBoard.dto.TodoPatchDto;
import com.toyspring.noticeBoard.dto.TodoPostDto;
import com.toyspring.noticeBoard.dto.TodoResponseDto;
import com.toyspring.noticeBoard.mapper.TodoMapper;
import com.toyspring.noticeBoard.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.util.List;


@RestController
@RequestMapping("/v2/todos")
@Slf4j
@Validated
public class TodoController {


    @Autowired
    private TodoService todoService;

    private TodoMapper mapper;

    public TodoController(TodoService todoService, TodoMapper mapper) {
        this.todoService = todoService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid TodoPostDto postDto){
      Todo todo = mapper.todoPostDtoToTodo(postDto);

      Todo createTodo = todoService.newWrite(todo);
      TodoResponseDto responseDto = mapper.todoToTodoResponseDto(createTodo);


      System.out.println("Todo 포스팅 완료");
      return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{todo_id}")
    public ResponseEntity update(@Positive @PathVariable("todo_id") @Min(1) Long todoId,@Valid @RequestBody TodoPatchDto requestBody){
        requestBody.setTodoId(todoId);

        Todo updateTodo = todoService.patch(mapper.todoPatchDtoToTodo(requestBody));

        System.out.println("Todo 패치 완료");
        return new ResponseEntity<>(mapper.todoToTodoResponseDto(updateTodo),HttpStatus.OK);
    }

    @GetMapping("/{todo_id}")
    public ResponseEntity findTodo(@Positive @PathVariable("todo_id") @Min(1) Long todoId){
        Todo todo = todoService.search(todoId);


        System.out.println("Todo 하나 찾기");
        return new ResponseEntity(todo,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity readAll(){
        List<Todo> findTodo = todoService.searchAll();

        System.out.println("Todo 모두 찾기");
        return new ResponseEntity<>(findTodo,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{todo_id}")
    public ResponseEntity delete(@Positive @PathVariable("todo_id") Long todoId){

       todoService.deleteTodo(todoId);

        System.out.println("Todo 삭제");
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    //회원정보처리 오류에 관한 예외에 대한 메서드입니다.
    @ExceptionHandler
    public ResponseEntity handleException(MethodArgumentNotValidException e){

        //잘못된 응답 데이터를 받았을 시 methodArgumentNotValidException 발동
        //보다 자세한 오류 사항 확인가능

//        ex)
//        [
//        {
//            "codes": [
//            "NotBlank.todoPostDto.title",
//                    "NotBlank.title",
//                    "NotBlank.java.lang.String",
//                    "NotBlank"
//        ],
//            "arguments": [
//            {
//                "codes": [
//                "todoPostDto.title",
//                        "title"
//                ],
//                "arguments": null,
//                    "defaultMessage": "title",
//                    "code": "title"
//            }
//        ],
//            "defaultMessage": "타이틀은 공백일 수 없습니다.",
//                "objectName": "todoPostDto",
//                "field": "title",
//                "rejectedValue": "",
//                "bindingFailure": false,
//                "code": "NotBlank"
//        }
//]

        final List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();

        return new ResponseEntity(fieldErrors, HttpStatus.BAD_REQUEST);
    }



}
