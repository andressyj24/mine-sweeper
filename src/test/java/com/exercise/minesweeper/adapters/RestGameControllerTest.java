package com.exercise.minesweeper.adapters;

import com.exercise.minesweeper.TestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RestGameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturn201WhenPostCreateNewGame() throws Exception {
        String createGameContent = TestUtils.loadFile("classpath:com.exercise.minesweeper/requests/new_game_request.json");
        this.mockMvc.perform(post("/api/games")
                .contentType(MediaType.APPLICATION_JSON)
                .content(createGameContent))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

}
