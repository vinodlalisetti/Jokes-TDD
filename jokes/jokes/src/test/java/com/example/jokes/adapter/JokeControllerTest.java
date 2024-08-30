package com.example.jokes.adapter;

import com.example.jokes.core.Joke;
import com.example.jokes.core.JokeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.mockito.Mockito.when;

@WebMvcTest(JokeController.class)
class JokeControllerTest {

    @MockBean
    private JokeService jokeService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetJokes() throws Exception {
        when(jokeService.getJokes(5)).thenReturn(List.of(
                new Joke("Setup 1", "Punchline 1"),
                new Joke("Setup 2", "Punchline 2"),
                new Joke("Setup 3", "Punchline 3"),
                new Joke("Setup 4", "Punchline 4"),
                new Joke("Setup 5", "Punchline 5")
        ));

        mockMvc.perform(get("/jokes?count=5"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"setup\":\"Setup 1\",\"punchline\":\"Punchline 1\"}," +
                        "{\"setup\":\"Setup 2\",\"punchline\":\"Punchline 2\"}," +
                        "{\"setup\":\"Setup 3\",\"punchline\":\"Punchline 3\"}," +
                        "{\"setup\":\"Setup 4\",\"punchline\":\"Punchline 4\"}," +
                        "{\"setup\":\"Setup 5\",\"punchline\":\"Punchline 5\"}]"));
    }
}
