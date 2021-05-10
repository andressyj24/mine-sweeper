package com.exercise.minesweeper.adapters;

import com.exercise.minesweeper.domain.*;
import com.exercise.minesweeper.ports.GameController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")
public class RestGameController implements GameController {


    public RestGameController(GameService gameService) {
        this.gameService = gameService;
    }

    private final GameService gameService;

    @GetMapping("/greeting")
    public String greeting() {
        return "Welcome to Minesweeper Game!";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public @ResponseBody MinesweeperGame createNewGame(@RequestBody NewGameRequest newGameRequest){
        return gameService.createNewGame(newGameRequest);
    }

    @Override
    public MinesweeperGame saveGame(SaveGameRequest saveGameRequest) {
        return null;
    }

    @Override
    public MinesweeperGame loadGame(LoadGameRequest loadGameRequest) {
        return null;
    }

    @Override
    public List<MinesweeperGame> getSavedGames(GetSavedGamesRequest getSavedGamesRequest) {
        return null;
    }
}
