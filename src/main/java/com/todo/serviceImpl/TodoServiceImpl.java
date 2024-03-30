package com.todo.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
	public boolean deleteTodo(int id) throws MyCustomException {
		Todo todo = getTodo(id);
		if(todo!=null) {
//			this.todoRepository.delete(todo);
			Date date=new Date();
			todo.setT_isCompleted(true);
			todo.setCompletedOn(date.toLocaleString());
			this.todoRepository.save(todo);
			return true;
		}
		return false;
	}

	@Override
	public List<Todo> getAllIncompltedTodo() {
	    List<Todo> allTodos = this.todoRepository.findAll();
	    List<Todo> incompleteTodos = allTodos.stream()
	                                         .filter(todo -> !todo.isT_isCompleted())
	                                         .collect(Collectors.toList());
	    return incompleteTodos;
	}

	@Override
	public List<Todo> getAllCompletedTodo() {
		List<Todo> findAll = this.todoRepository.findAll();
		List<Todo> collect = findAll.stream().filter(todo->todo.isT_isCompleted()).collect(Collectors.toList());
		return collect;
	}

}
