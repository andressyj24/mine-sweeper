package com.exercise.minesweeper.adapters;

import com.exercise.minesweeper.domain.GameService;
import com.exercise.minesweeper.domain.MinesweeperGame;
import com.exercise.minesweeper.ports.GameController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.exercise.minesweeper.adapters.GetGamesResponse.*;

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
    public @ResponseBody
    GameResponse createNewGame(@RequestBody NewGameRequest newGameRequest) {
        MinesweeperGame newGame = gameService.createNewGame(newGameRequest);
        return GameResponse.from(newGame);
    }

    @PatchMapping("/{gameId}/boards")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public @ResponseBody
    UpdateGameResponse updateGameWithAction(@RequestBody UpdateGameRequest updateGameRequest, @PathVariable String gameId) {
        MinesweeperGame currentGame = gameService.updateGame(updateGameRequest, gameId);
        return UpdateGameResponse.from(currentGame);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Override
    public @ResponseBody
    GetGamesResponse getGames() {
        List<MinesweeperGame> games = gameService.getGames();
        return from(games);
    }


    @GetMapping("/{gameId}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public @ResponseBody
    GetGamesResponse getGame(@PathVariable String gameId) {
        MinesweeperGame game = gameService.getGameById(gameId);
        return from(game);
    }


    //TODO: Implement this functionality
    @Override
    public GameResponse saveGame(SaveGameRequest saveGameRequest) {
        return new GameResponse();
    }

}
