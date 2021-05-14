package com.exercise.minesweeper.ports;

import com.exercise.minesweeper.adapters.*;

public interface GameController {

    GameResponse createNewGame(NewGameRequest newGameRequest);

    UpdateGameResponse updateGameWithAction(UpdateGameRequest updateGameRequest, String gameId);

    GetGamesResponse getGame(String gameId);

    GetGamesResponse getGames();

    GameResponse saveGame(SaveGameRequest saveGameRequest);

}
