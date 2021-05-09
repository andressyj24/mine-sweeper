package com.exercise.minesweeper.ports;

import com.exercise.minesweeper.domain.GetSavedGamesRequest;
import com.exercise.minesweeper.domain.LoadGameRequest;
import com.exercise.minesweeper.domain.NewGameRequest;
import com.exercise.minesweeper.domain.SaveGameRequest;
import com.exercise.minesweeper.domain.MinesweeperGame;

import java.util.List;

public interface GameController {

    MinesweeperGame createNewGame(NewGameRequest newGameRequest);

    MinesweeperGame saveGame(SaveGameRequest saveGameRequest);

    MinesweeperGame loadGame(LoadGameRequest loadGameRequest);

    List<MinesweeperGame> getSavedGames(GetSavedGamesRequest getSavedGamesRequest);
}
