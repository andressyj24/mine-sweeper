package com.exercise.minesweeper.domain;

import lombok.Data;

@Data
public class MinesweeperGame {

    private Board board;
    private Integer time;

    public MinesweeperGame(NewGameRequest newGameRequest) {
        this.board = new Board(newGameRequest.getRows(), newGameRequest.getColumns());
    }

}
