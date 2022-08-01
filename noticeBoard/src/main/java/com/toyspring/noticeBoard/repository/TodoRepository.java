package com.toyspring.noticeBoard.repository;

import com.toyspring.noticeBoard.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Long> {

}
