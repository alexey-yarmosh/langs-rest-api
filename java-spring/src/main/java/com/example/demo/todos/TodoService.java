package com.example.restservice;

import java.util.List;

public class TodoService {

	public static Todo getById(long id) {
		return TodoRepository.getById(id);
	}

	public static List<Todo> getAllTodos() {
		return TodoRepository.getAllTodos();
	}

}
