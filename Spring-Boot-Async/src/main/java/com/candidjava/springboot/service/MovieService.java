package com.candidjava.springboot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.candidjava.springboot.model.MovieModel;

import java.util.concurrent.CompletableFuture;

@Service
public class MovieService {

    private static final Logger LOG = LoggerFactory.getLogger(MovieService.class);

    private final RestTemplate restTemplate;

    public MovieService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    public CompletableFuture<MovieModel> lookForMovie(String movieId) throws InterruptedException {
        LOG.info("Looking up Movie ID: {}", movieId);
        String url = String.format("https://ghibliapi.herokuapp.com/films/%s", movieId);
        MovieModel results = restTemplate.getForObject(url, MovieModel.class);
        // Artificial delay of 1s for demonstration purposes
        Thread.sleep(1000L);
        return CompletableFuture.completedFuture(results);
    }
}
