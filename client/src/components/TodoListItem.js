import React from "react";
import "./TodoListItem.css";

const TodoListItem = ({ todoListItem, deleteTodoListItem }) => {
  const { title, contents } = todoListItem;
  return (
    <div className="todo--list--item">
      <p>{title}</p>
      <p>{contents}</p>
    </div>
  );
};

export default TodoListItem;
