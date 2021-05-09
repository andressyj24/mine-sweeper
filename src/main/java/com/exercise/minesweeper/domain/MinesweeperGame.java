package com.exercise.minesweeper.domain;

public class MinesweeperGame {

    private NewGameRequest newGameRequest;
    private Board board;
    private Integer time;

    public MinesweeperGame(NewGameRequest newGameRequest) {
        this.newGameRequest = newGameRequest;
    }
}
