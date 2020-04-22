package com.candidjava.springboot.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.candidjava.springboot.models.Todos;

@Service
public class TodosService {

	@Autowired
	private RestTemplate restTemplate;

	private static final String baseURL = "https://jsonplaceholder.typicode.com/todos";

	public List<Todos> getAllTodos() {
		Todos[] todos = restTemplate.getForObject(baseURL, Todos[].class);
		List<Todos> listOfTodos = Arrays.asList(todos);
		return listOfTodos;

	}

	public Todos getTodosById(String id) {
		Todos todo = restTemplate.getForObject(baseURL + "/" + id, Todos.class);
		return todo;
	}

}