// src/main/java/com/example/jokes/core/JokeService.java
package com.example.jokes.core;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface JokeService {
    List<Joke> getJokes(int count);
}
