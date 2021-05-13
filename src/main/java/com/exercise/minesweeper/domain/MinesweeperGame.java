package com.exercise.minesweeper.domain;

import com.exercise.minesweeper.adapters.NewGameRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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

    public MinesweeperGame openCell(CellPosition cellPosition) {
        boolean isCellClosed = this.board.getBoardCell(cellPosition).getState().equals(BoardCellState.CLOSED);
        if (this.status.equals(GameStatus.IN_PROGRESS) && isCellClosed) {
            this.board = this.board.openBoardCell(cellPosition);
            GameStatus status = this.board.getTotalEmptyCells().equals(0)? GameStatus.WIN : GameStatus.IN_PROGRESS;
            this.status = this.board.isMineOpened() ? GameStatus.OVER : status;
        }
        return this;
    }
}
