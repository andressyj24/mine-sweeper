package com.exercise.minesweeper.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class NewMinesweeperGameTest {

    @Test
    public void shouldCreateANewGameWithDefaultValuesForBoard() {
        NewGameRequest newGameRequest = new NewGameRequest(4, 3, 5, Difficulty.MEDIUM.toString());
        MinesweeperGame newMinesweeperGame = new MinesweeperGame(newGameRequest);
        Board newBoard = newMinesweeperGame.getBoard();
        assertBoard(newGameRequest, newBoard);
        assertBoardCells(newBoard);
        newBoard.printBoard();
    }

    @Test
    public void shouldCalculateNumberOfMinesBasedOnAreaAndMediumDifficulty() {
        NewGameRequest newGameRequest = new NewGameRequest(4, 3, 5, Difficulty.MEDIUM.toString());
        MinesweeperGame newMinesweeperGame = new MinesweeperGame(newGameRequest);
        Board newBoard = newMinesweeperGame.getBoard();
        Assertions.assertEquals(6, newBoard.getNumberOfMines());
    }

    @Test
    public void shouldCalculateNumberOfMinesBasedOnAreaAndEasyDifficulty() {
        NewGameRequest newGameRequest = new NewGameRequest(4, 3, 5, Difficulty.EASY.toString());
        MinesweeperGame newMinesweeperGame = new MinesweeperGame(newGameRequest);
        Board newBoard = newMinesweeperGame.getBoard();
        Assertions.assertEquals(2, newBoard.getNumberOfMines(), "Incorrect number of mines based on the difficulty");
    }

    @Test
    public void shouldCalculateNumberOfMinesBasedOnAreaAndHardDifficulty() {
        NewGameRequest newGameRequest = new NewGameRequest(4, 3, 5, Difficulty.HARD.toString());
        MinesweeperGame newMinesweeperGame = new MinesweeperGame(newGameRequest);
        Board newBoard = newMinesweeperGame.getBoard();
        Assertions.assertEquals(9, newBoard.getNumberOfMines(), "Incorrect number of mines based on the difficulty");
    }

    @Test
    public void shouldCreateANewGameWithTheMediumDifficulty() {
        NewGameRequest newGameRequest = new NewGameRequest(4, 3, 5, Difficulty.MEDIUM.toString());
        MinesweeperGame newMinesweeperGame = new MinesweeperGame(newGameRequest);
        Board newBoard = newMinesweeperGame.getBoard();
        assertDifficultyOfBoard(newBoard);
    }

    @Test
    public void shouldCreateANewGameWithTheHardDifficulty() {
        NewGameRequest newGameRequest = new NewGameRequest(4, 3, 5, Difficulty.HARD.toString());
        MinesweeperGame newMinesweeperGame = new MinesweeperGame(newGameRequest);
        Board newBoard = newMinesweeperGame.getBoard();
        assertDifficultyOfBoard(newBoard);
    }

    @Test
    public void shouldCreateANewGameWithZeroDifficulty() {
        NewGameRequest newGameRequest = new NewGameRequest(4, 3, 5, Difficulty.ZERO.toString());
        MinesweeperGame newMinesweeperGame = new MinesweeperGame(newGameRequest);
        Board newBoard = newMinesweeperGame.getBoard();
        assertDifficultyOfBoard(newBoard);
    }

    private void assertDifficultyOfBoard(Board newBoard) {
        int mineCounter = 0;
        for (int i = 0; i < newBoard.getRows(); i++) {
            BoardCell[] currentRow = newBoard.getBoardArea()[i];
            for (BoardCell currentCell : currentRow) {
                if (currentCell.getIsMined()) {
                    mineCounter++;
                }
            }
        }
        int cellsTotal = newBoard.getRows() * newBoard.getColumns();
        int expectedNumberOfMines = Math.round((cellsTotal * newBoard.getDifficulty().minedCellsPercentage) / 100);
        Assertions.assertEquals(expectedNumberOfMines, mineCounter, "Incorrect number of cells with mines based on the difficulty");
    }

    private void assertBoardCells(Board newBoard) {
        for (int i = 0; i < newBoard.getRows(); i++) {
            BoardCell[] currentRow = newBoard.getBoardArea()[i];
            for (BoardCell currentCell : currentRow) {
                Assertions.assertEquals(currentCell.getState(), BoardCellState.CLOSED,
                        "New Board cell must be CLOSED as initial state");
            }
        }

    }

    private void assertBoard(NewGameRequest newGameRequest, Board newBoard) {
        Assertions.assertEquals(newGameRequest.getRows(), newBoard.getRows(), "Number of rows does not match");
        Assertions.assertEquals(newGameRequest.getColumns(), newBoard.getColumns(), "Number of columns does not match");
    }
}
