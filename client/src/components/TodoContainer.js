import { useState, useEffect } from "react";
import "./TodoContainer.css";
import TodoList from "./TodoList";
import Modal from "./Modal";

const TodoContainer = () => {
  const [todolist, setTodolist] = useState([
    {
      title: "Lorem Ipsum",
      contents:
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
    },
    {
      title: "Lorem Ipsum",
      contents:
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
    },
    {
      title: "Lorem Ipsum",
      contents:
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
    },
    {
      title: "Lorem Ipsum",
      contents:
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
    },
    {
      title: "Lorem Ipsum",
      contents:
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
    },
    {
      title: "Lorem Ipsum",
      contents:
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
    },
    {
      title: "Lorem Ipsum",
      contents:
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
    },
    {
      title: "Lorem Ipsum",
      contents:
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
    },
    {
      title: "Lorem Ipsum",
      contents:
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
    },
  ]);

  const [modalIsOpened, setModalIsOpened] = useState(false);

  const openModal = () => {
    setModalIsOpened(true);
  };

  const closeModal = () => {
    setModalIsOpened(false);
  };

  const addNewTodo = function (newTodo) {
    setTodolist([...todolist, newTodo]);
  };

  return (
    <>
      <div className="todo--container">
        <h1
          onClick={() => {
            openModal();
          }}
        >
          My Notes +
        </h1>
        <Modal
          addNewTodo={addNewTodo}
          closeModal={closeModal}
          modalIsOpened={modalIsOpened}
        />
        <TodoList todoList={todolist} />
      </div>
    </>
  );
};

export default TodoContainer;
