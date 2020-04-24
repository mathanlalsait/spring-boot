package com.candidjava.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.candidjava.springboot.models.Todos;
import com.candidjava.springboot.service.TodosService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/todos")
public class TodosController {
	@Autowired
	TodosService service;

	@GetMapping("/getAll")
	public Flux<Todos> get() {
		return service.getAllTodos();
	}

	@GetMapping("/get/{id}")
	public Mono<Todos> getById(@PathVariable("id") String id) {
		return service.getTodosById(id);
	}

}