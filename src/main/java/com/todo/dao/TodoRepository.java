package com.todo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer>{

}
