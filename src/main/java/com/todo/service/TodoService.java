package com.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.todo.Exception.MyCustomException;
import com.todo.entity.Todo;

@Service
public interface TodoService {
	
	Todo addTodo(Todo todo);
	Todo getTodo(int t_id) throws MyCustomException;
	List<Todo> getAllCompletedTodo();
	boolean deleteTodo(int id) throws MyCustomException;
	List<Todo> getAllIncompltedTodo();

}
