package com.exercise.minesweeper.domain;

import lombok.Data;

import java.util.UUID;

@Data
public class MinesweeperGame {

    private UUID gameId;
    private Board board;
    private Integer time;

    public MinesweeperGame(NewGameRequest newGameRequest) {
        this.board = new Board(newGameRequest.getRows(), newGameRequest.getColumns(), newGameRequest.getDifficulty());
    }

}
