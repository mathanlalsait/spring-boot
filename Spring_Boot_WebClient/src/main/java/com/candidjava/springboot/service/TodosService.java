package com.candidjava.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.candidjava.springboot.models.Todos;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TodosService {

	@Autowired
	private WebClient.Builder webClientBuilder;

	private static final String baseURL = "https://jsonplaceholder.typicode.com/todos";

	public Flux<Todos> getAllTodos() {
		Flux<Todos> todos = webClientBuilder.build().get().uri(baseURL).retrieve().bodyToFlux(Todos.class);
		return todos;

	}

	public Mono<Todos> getTodosById(String id) {
		Mono<Todos> todo = webClientBuilder.build().get().uri(baseURL + "/" + id).retrieve().bodyToMono(Todos.class);
		return todo;
	}

}