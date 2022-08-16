package com.toyspring.noticeBoard.repository;

import com.toyspring.noticeBoard.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Member;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo,Long> {

}
