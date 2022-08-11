import React from "react";
import "./TodoList.css";
import TodoListItem from "./TodoListItem";

const TodoList = ({
  todoList,
  deleteTodoListItem,
  updateTodoListItem,
  openModal,
}) => {
  return (
    <div className="todo--list">
      {todoList.length === 0 ? (
        <div
          className="no--todo"
          onClick={() => {
            openModal();
          }}
        >
          <p>현재 페이지에 todo가 없습니다. todo를 입력하세요.</p>
        </div>
      ) : (
        todoList.map((todoListItem, idx) => {
          return (
            <TodoListItem
              key={idx}
              idx={idx + 1}
              todoListItem={todoListItem}
              deleteTodoListItem={deleteTodoListItem}
              updateTodoListItem={updateTodoListItem}
            />
          );
        })
      )}
    </div>
  );
};

export default TodoList;
