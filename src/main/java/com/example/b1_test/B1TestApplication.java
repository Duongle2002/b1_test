package com.example.b1_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class B1TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(B1TestApplication.class, args);
		System.out.println("Hello World");

	}
}
@Controller
@RequestMapping("/todos")
class TodoController {

	// In-memory list of todos
	// In a real application, this would be replaced by a database
	// or other persistent storage
	private List<Todo> todos = new ArrayList<>();

	@GetMapping
	public String getAllTodos(Model model) {
		model.addAttribute("todos", todos);
		model.addAttribute("todo", new Todo());
		return "todo-list";
	}

	@PostMapping
	public String addTodo(@ModelAttribute Todo todo) {
		todo.setId(UUID.randomUUID().toString());
		todos.add(todo);
		return "redirect:/todos";
	}

	@PostMapping("/{id}/complete")
	public String completeTodo(@PathVariable String id) {
		todos.stream()
				.filter(todo -> todo.getId().equals(id))
				.findFirst()
				.ifPresent(todo -> todo.setCompleted(true));
		return "redirect:/todos";
	}

	// REST API endpoints (kept from previous version)
	@GetMapping("/api")
	@ResponseBody
	public List<Todo> getAllTodosApi() {
		return todos;
	}

	@PostMapping("/api")
	@ResponseBody
	public Todo addTodoApi(@RequestBody Todo todo) {
		todo.setId(UUID.randomUUID().toString());
		todos.add(todo);
		return todo;
	}
}

class Todo {
	private String id;
	private String task;
	private boolean completed;

	// Getters and Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
}