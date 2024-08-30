// src/main/java/com/example/jokes/adapter/JokeClientImpl.java
package com.example.jokes.adapter;

import com.example.jokes.core.Joke;
import com.example.jokes.port.JokeClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class JokeClientImpl implements JokeClient {

    private final RestTemplate restTemplate;

    public JokeClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Joke> fetchJokes(int count) {
        List<Joke> jokes = new ArrayList<>();
        while (count > 0) {
            Joke joke = restTemplate.getForObject("https://official-joke-api.appspot.com/random_joke", Joke.class);
            if (joke != null) {
                jokes.add(joke);
            }
            count--;
        }
        return jokes;
    }
}
