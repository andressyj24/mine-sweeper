package com.exercise.minesweeper.domain;

import org.hamcrest.Matchers;
import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Ignore
    @Test
    public void shouldOpenAllImmediateEmptyNeighborsCellsGivenASingleEmptyCell() {
        Board board = new Board(4, 4, Difficulty.ZERO.toString());
        BoardCell currentCell = board.openBoardCell(new CellPosition(1, 1));
        assertNeighborsCells(currentCell, board);
    }

    private void assertNeighborsCells(BoardCell currentCell, Board board) {

    }


    private void assertEntireBoardIsOpened(Board board) {
        for (int row = 0; row < board.getRows(); row++) {
            for (int col = 0; col < board.getColumns(); col++) {
                Assertions.assertEquals(BoardCellState.CLOSED, board.getBoardCell(new CellPosition(row, col)).getState(),
                        "Adyacente cell is not uncovered: " + row + " : " + col);
            }
        }
    }
}
