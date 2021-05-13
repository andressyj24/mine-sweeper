package com.exercise.minesweeper.adapters;

import com.exercise.minesweeper.TestUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.UnsupportedEncodingException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RestGameControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private String rootUrl;

    @BeforeEach
    public void before() {
        this.rootUrl = "/api/games";
    }

    @Test
    public void shouldReturn201WhenPostCreateNewGame() throws Exception {
        String createGameContent = TestUtils.loadFile("classpath:com.exercise.minesweeper/requests/new_game_request.json");
        this.mockMvc.perform(post(rootUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .content(createGameContent))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void shouldReturn200WhenOpenACell() throws Exception {
        String createGameContent = TestUtils.loadFile("classpath:com.exercise.minesweeper/requests/new_game_request.json");
        MvcResult createResult = this.mockMvc.perform(post("/api/games")
                .contentType(MediaType.APPLICATION_JSON)
                .content(createGameContent))
                .andReturn();

        MockHttpServletResponse response = createResult.getResponse();
        String gameId = getAsJsonObject(response).get("game_id").getAsString();

        this.mockMvc.perform(patch(rootUrl.concat("/").concat(gameId).concat("/boards"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(createGameContent))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

    }

    @Test
    public void shouldReturn200WhenQueryAGameById() throws Exception {
        String createGameContent = TestUtils.loadFile("classpath:com.exercise.minesweeper/requests/new_game_request.json");
        MvcResult createResult = this.mockMvc.perform(post("/api/games")
                .contentType(MediaType.APPLICATION_JSON)
                .content(createGameContent))
                .andReturn();

        MockHttpServletResponse response = createResult.getResponse();
        String gameId = getAsJsonObject(response).get("game_id").getAsString();

        this.mockMvc.perform(get(rootUrl.concat("/").concat(gameId))
                .contentType(MediaType.APPLICATION_JSON)
                .content(createGameContent))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

    }

    private JsonObject getAsJsonObject(MockHttpServletResponse response) throws UnsupportedEncodingException {
        return new Gson().fromJson(response.getContentAsString(), JsonObject.class);
    }

}
