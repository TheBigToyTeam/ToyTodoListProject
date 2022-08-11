import React from "react";
import "./Modal.css";

const Modal = (props) => {
  const { modalIsOpened, closeModal, addNewTodo } = props;

  const handleSubmit = (e) => {
    e.preventDefault();
    const title = e.target[1].value;
    const contents = e.target[2].value;
    addNewTodo({ title, contents });
  };

  return (
    <div
      className={
        modalIsOpened ? "openedModal modal--container" : "modal--container"
      }
      onClick={closeModal}
    >
      {modalIsOpened ? (
        <div className="modal--body" onClick={(e) => e.stopPropagation()}>
          <form method="get" className="form" onSubmit={handleSubmit}>
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
              <button className="add--btn" type="submit">
                add
              </button>
            </footer>
          </form>
        </div>
      ) : null}
    </div>
  );
};

export default Modal;
