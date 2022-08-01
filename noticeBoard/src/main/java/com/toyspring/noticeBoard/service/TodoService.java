package com.toyspring.noticeBoard.service;

import com.toyspring.noticeBoard.Entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TodoService {

    public Todo createTodo(Todo todo);

    public Todo updateTodo(Todo todo);

    public Todo findByTodo(Long todoId);

    public List<Todo> findTodos();

    public void deleteTodo(Long todoId);
}
