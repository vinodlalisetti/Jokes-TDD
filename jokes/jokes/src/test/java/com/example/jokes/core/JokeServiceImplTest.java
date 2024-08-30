// src/test/java/com/example/jokes/core/JokeServiceImplTest.java
package com.example.jokes.core;

import com.example.jokes.adapter.JokeController;
import com.example.jokes.port.JokeClient;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.testng.annotations.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@WebMvcTest(JokeServiceImpl.class)
class JokeServiceImplTest {

    @MockBean
    private JokeClient jokeClient;

    @Autowired
    private JokeService jokeService;


    @Test
    void testGetJokes() {
        when(jokeClient.fetchJokes(10)).thenReturn(List.of(
                new Joke("Setup 1", "Punchline 1"),
                new Joke("Setup 2", "Punchline 2"),
                new Joke("Setup 3", "Punchline 3"),
                new Joke("Setup 4", "Punchline 4"),
                new Joke("Setup 5", "Punchline 5"),
                new Joke("Setup 6", "Punchline 6"),
                new Joke("Setup 7", "Punchline 7"),
                new Joke("Setup 8", "Punchline 8"),
                new Joke("Setup 9", "Punchline 9"),
                new Joke("Setup 10", "Punchline 10")
        ));

        List<Joke> jokes = jokeService.getJokes(5);

        assertEquals(5, jokes.size());
        assertEquals("Setup 1 - Punchline 1", jokes.get(0).toString());
        verify(jokeClient, times(1)).fetchJokes(10);
    }
}
