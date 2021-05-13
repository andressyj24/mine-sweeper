package com.exercise.minesweeper.domain;

import com.exercise.minesweeper.adapters.NewGameRequest;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;

public class GameplayTest {

    @Test
    public void shouldRevealSelectedBoardCellInBoard() {
        Board board = new Board(3, 3, Difficulty.ZERO.toString());
        board.openBoardCell(new CellPosition(0, 0));
        BoardCell boardCell = board.getBoardCell(new CellPosition(0, 0));
        Assertions.assertEquals(BoardCellState.OPENED, boardCell.getState());
    }

    @Test
    public void shouldIdentifyNeighborsCellsGivenASingleCell() {
        Board board = new Board(4, 4, Difficulty.ZERO.toString());
        List<BoardCell> boardCellNeighbors = board.getNeighborsOf(new CellPosition(1, 1));
        List<BoardCell> expectedNeighbors = createExpectedNeighbors();
        assertThat(boardCellNeighbors, Matchers.containsInAnyOrder(expectedNeighbors.toArray()));
    }

    @Test
    public void shouldOpenNearestNeighborsGivenAnEmptyBoardCell() {
        NewGameRequest gameRequest = new NewGameRequest(3, 3, 1, Difficulty.ZERO.toString());
        MinesweeperGame newGame = new MinesweeperGame(gameRequest);
        newGame.openCell(new CellPosition(0, 0));
        List<CellPosition> expectedPositions = List.of(new CellPosition(0, 0),
                new CellPosition(0, 1),
                new CellPosition(1, 0),
                new CellPosition(1, 1));
        assertOpenBoardCellsInBoard(newGame.getBoard(), expectedPositions);
        newGame.getBoard().printBoard();
    }

    @Test
    public void shouldTerminateGameWhenOpenedCellHasAMine() {
        NewGameRequest gameRequest = new NewGameRequest(3, 3, 1, Difficulty.MEDIUM.toString());
        MinesweeperGame newGame = new MinesweeperGame(gameRequest);
        newGame.getBoard().getBoardCell(new CellPosition(0, 0)).setIsMined(true);
        newGame.openCell(new CellPosition(0, 0));
        Assertions.assertEquals(newGame.getStatus(), GameStatus.OVER);
    }

    @Test
    public void shouldTerminateGameWhenAllSafeCellsAreDiscovered() {
        NewGameRequest gameRequest = new NewGameRequest(3, 3, 1, Difficulty.ZERO.toString());
        MinesweeperGame newGame = new MinesweeperGame(gameRequest);
        newGame.openCell(new CellPosition(1, 1));
        Assertions.assertEquals(newGame.getStatus(), GameStatus.WIN);
    }

    @Test
    public void shouldGameBeInProgressWhenOpenedCellIsEmpty() {
        NewGameRequest gameRequest = new NewGameRequest(3, 3, 1, Difficulty.ZERO.toString());
        MinesweeperGame newGame = new MinesweeperGame(gameRequest);
        newGame.openCell(new CellPosition(0, 0));
        Assertions.assertEquals(newGame.getStatus(), GameStatus.IN_PROGRESS);
    }


    private List<BoardCell> createExpectedNeighbors() {
        BoardCellState defaultState = BoardCellState.CLOSED;
        return List.of(new BoardCell(new CellPosition(0, 1), defaultState, false),
                new BoardCell(new CellPosition(0, 2), defaultState, false),
                new BoardCell(new CellPosition(1, 2), defaultState, false),
                new BoardCell(new CellPosition(2, 2), defaultState, false),
                new BoardCell(new CellPosition(2, 1), defaultState, false),
                new BoardCell(new CellPosition(2, 0), defaultState, false),
                new BoardCell(new CellPosition(1, 0), defaultState, false),
                new BoardCell(new CellPosition(0, 0), defaultState, false));

    }


    private void assertOpenBoardCellsInBoard(Board board, List<CellPosition> cellPositions) {
        List<BoardCell> boardCells = cellPositions.isEmpty() ? board.getAllBoardCells() : board.getListOfBoardCells(cellPositions);
        List<BoardCell> filteredBoardCells = boardCells.stream()
                .filter(cp -> cp.getState().equals(BoardCellState.OPENED))
                .collect(Collectors.toList());
        Assertions.assertEquals(cellPositions.size(), filteredBoardCells.size(), "Incorrect number of BoardCells opened");
    }
}
