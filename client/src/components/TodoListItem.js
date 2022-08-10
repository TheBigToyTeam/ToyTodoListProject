import { useState, useEffect } from "react";
import "./TodoListItem.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faTrashCan } from "@fortawesome/free-solid-svg-icons";
import { faSquareCheck } from "@fortawesome/free-solid-svg-icons";
import { faPencil } from "@fortawesome/free-solid-svg-icons";

const TodoListItem = ({
  todoListItem,
  deleteTodoListItem,
  updateTodoListItem,
}) => {
  const { title, contents } = todoListItem;
  const [todoChecked, setTodoChecked] = useState(false);

  const handleClick = () => {
    setTodoChecked(!todoChecked);
  };

  let colorNum = "color" + Math.floor(Math.random() * 10);

  // const aaa = document.querySelector(".todo--list--item");
  // if (setTodoChecked === false) {
  //   aaa.style.filter = "grayscale(100%)";
  // }

  return (
    <div className="todo--list--item" id={colorNum}>
      <p>{title}</p>
      <p>{contents}</p>
      <FontAwesomeIcon
        className="pencil icon"
        icon={faPencil}
        onClick={updateTodoListItem}
      />
      <FontAwesomeIcon
        className="trash icon"
        icon={faTrashCan}
        onClick={deleteTodoListItem}
      />
      <FontAwesomeIcon
        className="checkbox icon"
        icon={faSquareCheck}
        onClick={handleClick}
      />
    </div>
  );
};

export default TodoListItem;
