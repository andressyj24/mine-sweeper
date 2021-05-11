package com.exercise.minesweeper.ports;

import com.exercise.minesweeper.domain.*;

import java.util.List;

public interface GameController {

    NewGameResponse createNewGame(NewGameRequest newGameRequest);

    MinesweeperGame saveGame(SaveGameRequest saveGameRequest);

    MinesweeperGame loadGame(LoadGameRequest loadGameRequest);

    List<MinesweeperGame> getSavedGames(GetSavedGamesRequest getSavedGamesRequest);
}
