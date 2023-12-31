package com.project.kanban.springboot.springbootbackend;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoResource {
	private TodoService todoService;
	
	public TodoResource(TodoService todoService) {
		this.todoService = todoService;
	}

	@GetMapping("/{status}/todos")
	public List<Todo> retrieveTodos(@PathVariable String status) {
		return todoService.findByStatus(status);
	}
	
	@GetMapping("/{status}/todos/{id}")
	public Todo retrieveTodo(@PathVariable String status,@PathVariable int id) {
		return todoService.findById(id);
	}
	
	@DeleteMapping("/{status}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String status,@PathVariable int id) {
		todoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{status}/todos/{id}")
	public Todo updateTodo(@PathVariable String status,@PathVariable int id, @RequestBody Todo todo) {
		todoService.updateTodo(todo);
		return todo;
	}
	
	@PostMapping("/{status}/todos")
	public Todo createTodo(@PathVariable String status, @RequestBody Todo todo) {
		todoService.addTodo(todo.getTitle(),status);
		return todo;
	}
}
