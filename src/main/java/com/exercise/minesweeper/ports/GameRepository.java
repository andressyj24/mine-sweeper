package com.exercise.minesweeper.ports;

import com.exercise.minesweeper.domain.MinesweeperGame;

public interface GameRepository {

    MinesweeperGame getGameById(String gameId);

    MinesweeperGame saveGame(MinesweeperGame game);

    MinesweeperGame updateGame(MinesweeperGame game);
}
