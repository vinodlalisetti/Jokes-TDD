// src/main/java/com/example/jokes/adapter/JokeController.java
package com.example.jokes.adapter;

import com.example.jokes.core.Joke;
import com.example.jokes.core.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JokeController {

    private final JokeService jokeService;

    @Autowired
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }


    @GetMapping("/jokes")
    public List<Joke> getJokes(@RequestParam int count) {
        return jokeService.getJokes(count);
    }
}
