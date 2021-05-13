package com.exercise.minesweeper.ports;

import com.exercise.minesweeper.adapters.*;
import com.exercise.minesweeper.domain.MinesweeperGame;

public interface GameController {

    GameResponse createNewGame(NewGameRequest newGameRequest);

    UpdateGameResponse openBoardCell(UpdateGameRequest updateGameRequest, String gameId);

    GetGamesResponse getGame(String gameId);

    GetGamesResponse getGames();

    MinesweeperGame saveGame(SaveGameRequest saveGameRequest);

}
