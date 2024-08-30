// src/main/java/com/example/jokes/core/JokeServiceImpl.java
package com.example.jokes.core;

import com.example.jokes.port.JokeClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JokeServiceImpl implements JokeService {

    private final JokeClient jokeClient;

    public JokeServiceImpl(JokeClient jokeClient) {
        this.jokeClient = jokeClient;
    }

    @Override
    public List<Joke> getJokes(int count) {
        List<Joke> jokes = new ArrayList<>();
        int batches = (count + 9) / 10; // Calculate number of batches needed

        for (int i = 0; i < batches; i++) {
            List<Joke> batch = jokeClient.fetchJokes(10); // Fetch a batch of 10 jokes
            jokes.addAll(batch);
        }

        return jokes.subList(0, Math.min(count, jokes.size())); // Return only the requested count
    }
}
