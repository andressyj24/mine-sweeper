package com.exercise.minesweeper.domain;

import lombok.Data;

@Data
public class Board {

    private BoardCell[][] boardArea;

    public Board(Integer rows, Integer columns) {
        boardArea = initializeBoard(rows, columns);
    }

    private BoardCell[][] initializeBoard(Integer rows, Integer columns) {
        this.boardArea = new BoardCell[rows][columns];
        for (int row = 0; row < this.getRows(); row++) {
            BoardCell[] currentRow = this.boardArea[row];
            for (int col = 0; col < currentRow.length; col++) {
               currentRow[col] = new BoardCell(row, col, BoardCellState.COVERED, true);
            }
        }
        return boardArea;
    }

    public void printBoard() {
        for (int row = 0; row < this.getRows(); row++) {
            BoardCell[] currentRow = this.boardArea[row];
            for (BoardCell boardCell : currentRow) {
                System.out.print("| " + boardCell);
            }
            System.out.println();
        }
    }

    public Integer getRows() {
        if (boardArea == null)
            return 0;
        return this.boardArea.length;
    }

    public Integer getColumns() {
        if (boardArea == null)
            return 0;
        return this.boardArea[0].length;
    }
}
