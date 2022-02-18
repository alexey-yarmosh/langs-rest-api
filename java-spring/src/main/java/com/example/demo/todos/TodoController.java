
package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class TodoController {

	@RequestMapping(value="/todos/{id}", method=RequestMethod.GET)
	public Todo todo(@PathVariable(value = "id") long id) {
		return TodoService.getById(id);
	}

	@RequestMapping(value="/todos", method=RequestMethod.GET)
	public List<Todo> allTodos() {
		return TodoService.getAllTodos();
	}

}
