package com.exercise.minesweeper.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class NewMinesweeperGameTest {

    @Test
    public void shouldCreateANewGameWithDefaultValuesForBoard() {
        NewGameRequest newGameRequest = new NewGameRequest(4, 3, 5);
        MinesweeperGame newMinesweeperGame = new MinesweeperGame(newGameRequest);
        Board newBoard = newMinesweeperGame.getBoard();
        assertBoard(newGameRequest, newBoard);
        assertBoardCells(newBoard);
        newBoard.printBoard();
    }

    private void assertBoardCells(Board newBoard) {
        for (int i = 0; i < newBoard.getRows(); i++) {
            BoardCell[] currentRow = newBoard.getBoardArea()[i];
            for (BoardCell currentCell : currentRow) {
                Assertions.assertEquals(currentCell.getState(), BoardCellState.COVERED,
                        "New Board cell must be COVERED as initial state");
            }
        }

    }

    private void assertBoard(NewGameRequest newGameRequest, Board newBoard) {
        Assertions.assertEquals(newGameRequest.getRows(), newBoard.getRows(), "Number of rows does not match");
        Assertions.assertEquals(newGameRequest.getColumns(), newBoard.getColumns(), "Number of columns does not match");
    }
}
