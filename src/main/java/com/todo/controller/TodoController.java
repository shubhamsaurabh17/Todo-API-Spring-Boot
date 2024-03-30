package com.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.todo.Exception.MyCustomException;
import com.todo.entity.Todo;
import com.todo.service.TodoService;

@RestController
@CrossOrigin("*")
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@PostMapping("/todo")
	public Todo addTodo(@RequestBody Todo todo) {
		Todo addTodo = this.todoService.addTodo(todo);
		return addTodo;
	}
	
	@GetMapping("/todo/{id}")
	public Todo getTodo(@PathVariable("id") int id) throws MyCustomException {
		Todo todo = this.todoService.getTodo(id);
		return todo;
	}
	
	@GetMapping("/todo")
	public List<Todo> getAllTodos(){
		List<Todo> allTodo = this.todoService.getAllCompletedTodo();
		return allTodo;
	}
	
	@DeleteMapping("/todo/{id}")
	public boolean deleteTodo(@PathVariable("id") int id) throws MyCustomException {
		boolean deleteTodo = this.todoService.deleteTodo(id);
		return deleteTodo;
	}
	
	@GetMapping("/todoIn")
	public List<Todo> getAllTodosIn(){
		List<Todo> allTodo = this.todoService.getAllIncompltedTodo();
		return allTodo;
	}

}
