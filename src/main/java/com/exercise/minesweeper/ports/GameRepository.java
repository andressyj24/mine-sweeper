package com.exercise.minesweeper.ports;

import com.exercise.minesweeper.domain.MinesweeperGame;

import java.util.List;

public interface GameRepository {

    MinesweeperGame getGameById(String gameId);

    MinesweeperGame saveGame(MinesweeperGame game);

    MinesweeperGame updateGame(MinesweeperGame game);

    List<MinesweeperGame> getGames();
}
