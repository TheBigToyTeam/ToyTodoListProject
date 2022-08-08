import { useState, useEffect } from "react";
import "./TodoContainer.css";
import TodoList from "./TodoList";
import Modal from "./Modal";

const TodoContainer = () => {
  const [todolist, setTodolist] = useState([
    // {
    //   title: "Lorem Ipsum",
    //   contents:
    //     "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
    // },
    // {
    //   title: "Lorem Ipsum",
    //   contents:
    //     "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
    // },
    // {
    //   title: "Lorem Ipsum",
    //   contents:
    //     "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
    // },
    // {
    //   title: "Lorem Ipsum",
    //   contents:
    //     "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
    // },
    // {
    //   title: "Lorem Ipsum",
    //   contents:
    //     "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
    // },
    // {
    //   title: "Lorem Ipsum",
    //   contents:
    //     "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
    // },
    // {
    //   title: "Lorem Ipsum",
    //   contents:
    //     "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
    // },
    // {
    //   title: "Lorem Ipsum",
    //   contents:
    //     "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
    // },
    // {
    //   title: "Lorem Ipsum",
    //   contents:
    //     "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
    // },
  ]);

  const [modalIsOpened, setModalIsOpened] = useState(false);

  const openModal = () => {
    setModalIsOpened(true);
  };

  const closeModal = () => {
    setModalIsOpened(false);
  };

  useEffect(() => {
    getTodoList();
  }, [todolist]);

  const getTodoList = () => {
    return fetch(/* "http://localhost:8080/v2/todos" */)
      .then((res) => res.json())
      .then((todoItem) => {
        setTodolist(todoItem);
      });
  };

  const addNewTodo = (newTodo) => {
    if (todolist.length >= 9) {
      window.alert("todo 생성은 최대 9개 까지만 가능합니다");
    } else {
      setTodolist([...todolist, newTodo]);
    }
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
          todolist={todolist}
          addNewTodo={addNewTodo}
          closeModal={closeModal}
          modalIsOpened={modalIsOpened}
        />
        <TodoList
          todoList={todolist}
          deleteTodoListItem={deleteTodo}
          updateTodoListItem={updateTodo}
          openModal={openModal}
        />
      </div>
    </>
  );
};

export default TodoContainer;
