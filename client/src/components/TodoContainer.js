import React from "react";
import "./TodoContainer.css";
import TodoList from "./TodoList";

const TodoContainer = () => {
  return (
    <>
      <div className="todo--container">
        <h1>My Notes +</h1>
        <TodoList />
      </div>
    </>
  );
};

export default TodoContainer;
