import React from "react";
import "./TodoList.css";
import TodoListItem from "./TodoListItem";

const TodoList = ({ todoList, deleteTodoListItem }) => {
  return (
    <div className="todo--list">
      {todoList.map((todoListItem, key) => {
        return (
          <TodoListItem
            key={key}
            todoListItem={todoListItem}
            deleteTodoListItem={deleteTodoListItem}
          />
        );
      })}
    </div>
  );
};

export default TodoList;
