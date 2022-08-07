import { useState, useEffect } from "react";
import "./TodoContainer.css";
import TodoList from "./TodoList";
import Modal from "./Modal";

const TodoContainer = () => {
  const [todolist, setTodolist] = useState([
    // api 통해 데이터 잘 확인되면 빈 배열로 바꿀 것
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

  useEffect(() => {
    getTodoList();
  }, [todolist]);

  const getTodoList = () => {
    return (
      fetch(/* 건휘형한테 말해서 주소 받아올 것 */)
        // postman으로 api 테스트해보기
        .then((res) => res.json())
        .then((todoItem) => {
          setTodolist(todoItem);
        })
    );
  };

  const [modalIsOpened, setModalIsOpened] = useState(false);

  const openModal = () => {
    setModalIsOpened(true);
  };

  const closeModal = () => {
    setModalIsOpened(false);
  };

  const addNewTodo = (newTodo) => {
    setTodolist([...todolist, newTodo]);
  };

  const deleteTodo = ({ title, contents }) => {};

  const updateTodo = (id) => {};

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
        <TodoList
          todoList={todolist}
          deleteTodoListItem={deleteTodo}
          updateTodoListItem={updateTodo}
        />
      </div>
    </>
  );
};

export default TodoContainer;
