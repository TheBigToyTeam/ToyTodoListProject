import { useState, useEffect } from "react";
import "./TodoContainer.css";
import TodoList from "./TodoList";
import Modal from "./Modal";

const TodoContainer = () => {
  const [todolist, setTodolist] = useState([
    { title: "Aaaa", contents: "fdfdfdf" },
  ]);
  const [modalIsOpened, setModalIsOpened] = useState(false);

  const openModal = () => {
    if (todolist.length >= 9) {
      window.alert("todo 생성은 최대 9개 까지만 가능합니다");
    } else {
      setModalIsOpened(true);
    }
  };

  const closeModal = () => {
    setModalIsOpened(false);
  };

  useEffect(() => {
    getTodoList();
  }, [todolist]);

  const getTodoList = () => {
    return fetch("http://localhost:8080/v2/todos/")
      .then((res) => res.json())
      .then((todoItem) => {
        setTodolist(todoItem);
      });
  };

  const addNewTodo = ({ title, contents }) => {
    if (todolist.length >= 9) {
      window.alert("todo 생성은 최대 9개 까지만 가능합니다");
    } else {
      const newTodo = {
        title: title,
        contents: contents,
      };

      fetch("http://localhost:8080/vs/todos/", {
        method: "POST",
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
        },
        body: JSON.stringify(newTodo),
      }).then((res) => {
        if (res.status === 201) {
          getTodoList();
        }
      });
    }
  };

  const deleteTodo = (id) => {
    fetch(`http://localhost:8080/v2/todos/${id}`, { method: "DELETE" }) //
      .then((res) => {
        if (res.status === 202 || 204) {
          getTodoList();
        }
      });
  };

  const updateTodo = () => {
    setModalIsOpened(true);
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
