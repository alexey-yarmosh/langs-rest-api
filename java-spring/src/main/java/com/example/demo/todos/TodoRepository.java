package com.example.restservice;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TodoRepository {

	public static Todo getById(long id) {
		Data data = TodoRepository.readFile();
		return data.todos.stream().filter(todo -> todo.id == id).findFirst().orElse(new Todo());
	}

	public static List<Todo> getAllTodos() {
		Data data = TodoRepository.readFile();
		return data.todos;
	}

	private static Data readFile() {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			Data file = objectMapper.readValue(new File("src/main/java/com/example/demo/todos/data.json"), Data.class);
			System.out.println(objectMapper.writeValueAsString(file));
			return file;
		} catch(IOException e) {
			e.printStackTrace();
			return new Data();
		}
	}

}
