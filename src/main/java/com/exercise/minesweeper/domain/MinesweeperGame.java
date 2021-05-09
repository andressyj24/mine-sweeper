package com.exercise.minesweeper.domain;

import lombok.Data;

@Data
public class MinesweeperGame {

    private NewGameRequest newGameRequest;
    private Board board;
    private Integer time;

    public MinesweeperGame(NewGameRequest newGameRequest) {
        this.newGameRequest = newGameRequest;
    }

}
