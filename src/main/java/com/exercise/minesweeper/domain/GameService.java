package com.exercise.minesweeper.domain;

import org.springframework.stereotype.Service;

@Service
public class GameService {
    public MinesweeperGame createNewGame(NewGameRequest newGameRequest) {
        return new MinesweeperGame(newGameRequest);
    }
}
