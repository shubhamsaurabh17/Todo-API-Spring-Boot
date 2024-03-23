package com.todo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.Exception.MyCustomException;
import com.todo.dao.TodoRepository;
import com.todo.entity.Todo;
import com.todo.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService{
	
	@Autowired
	private TodoRepository todoRepository;

	@Override
	public Todo addTodo(Todo todo) {
		Todo savedTodo = this.todoRepository.save(todo);
		return savedTodo;
	}

	@Override
	public Todo getTodo(int t_id) throws MyCustomException{
	    Todo orElseThrow = this.todoRepository.findById(t_id)
	            .orElseThrow(() -> new MyCustomException("Todo with ID " + t_id + " not found"));
	    return orElseThrow;
	}

	@Override
	public List<Todo> getAllTodo() {
		List<Todo> getAllTodo = this.todoRepository.findAll();
		return getAllTodo;
	}

	@Override
	public boolean deleteTodo(int id) throws MyCustomException {
		Todo todo = getTodo(id);
		if(todo!=null) {
			this.todoRepository.delete(todo);
			return true;
		}
		return false;
	}

}
