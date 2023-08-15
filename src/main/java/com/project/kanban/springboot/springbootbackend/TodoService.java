package com.project.kanban.springboot.springbootbackend;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
private static List<Todo> todos = new ArrayList<>();
	
	private static int todosCount = 0;
	
	static {
		todos.add(new Todo(++todosCount, "Task 1","To_Do" ));
		todos.add(new Todo(++todosCount, "Task 2","In_Progress"));
		todos.add(new Todo(++todosCount, "Task 3", "Done" ));
		todos.add(new Todo(++todosCount, "Task 4", "To_Do" ));
		todos.add(new Todo(++todosCount, "Task 5", "In_Progress" ));
		todos.add(new Todo(++todosCount, "Task 6", "Done" ));
	}
	
	public List<Todo> findByStatus(String status){
		Predicate<? super Todo> predicate = 
				todo -> todo.getStatus().equalsIgnoreCase(status);
		return todos.stream().filter(predicate).toList();
	}
	
	public Todo addTodo(String title, String status) {
		Todo todo = new Todo(++todosCount,title,status);
		todos.add(todo);
		return todo;
	}
	
	public void deleteById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}

}
