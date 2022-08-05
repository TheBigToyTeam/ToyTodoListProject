import React from "react";
import "./Modal.css";

const Modal = (props) => {
  const { modalIsOpened, closeModal, addNewTodo } = props;

  return (
    <div
      className={
        modalIsOpened ? "openedModal modal--container" : "modal--container"
      }
    >
      {modalIsOpened ? (
        <div className="modal--body">
          <header>
            <h1>Todo 생성</h1>
            <button className="close" onClick={closeModal}>
              &times;
            </button>
          </header>
          <main>
            <div>
              <div>Todo title</div>
              <input className="todo--title"></input>
            </div>
            <div>
              <div>Todo contents(선택)</div>
              <textarea className="todo--contents"></textarea>
            </div>
          </main>
          <footer>
            <button classNAme="add--btn" onClick={addNewTodo}>
              add
            </button>
          </footer>
        </div>
      ) : null}
    </div>
  );
};

export default Modal;
