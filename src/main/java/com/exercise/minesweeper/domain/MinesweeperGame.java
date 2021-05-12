package com.exercise.minesweeper.domain;

import lombok.Data;

@Data
public class MinesweeperGame {

    private String gameId;
    private String userName;
    private Board board;
    private Integer time;
    private GameStatus status;

    public MinesweeperGame(NewGameRequest newGameRequest) {
        this.board = new Board(newGameRequest.getRows(), newGameRequest.getColumns(), newGameRequest.getDifficulty());
        this.status = GameStatus.IN_PROGRESS;
    }

    public void openCell(CellPosition cellPosition) {
        if (this.status.equals(GameStatus.IN_PROGRESS)) {
            this.board = this.board.openBoardCell(cellPosition);
            this.status = this.board.isMineOpened() ? GameStatus.OVER : GameStatus.IN_PROGRESS;
        }
    }
}
