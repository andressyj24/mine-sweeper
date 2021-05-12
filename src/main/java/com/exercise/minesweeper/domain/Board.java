package com.exercise.minesweeper.domain;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@Data
public class Board {

    private BoardCell[][] boardArea;
    private Difficulty difficulty;

    public Board(Integer rows, Integer columns, String difficulty) {
        boardArea = initializeBoard(rows, columns);
        this.difficulty = Difficulty.valueOf(difficulty);
        this.loadMinesInBoard();
    }

    private BoardCell[][] initializeBoard(Integer rows, Integer columns) {
        this.boardArea = new BoardCell[rows][columns];
        for (int row = 0; row < this.getRows(); row++) {
            BoardCell[] currentRow = this.boardArea[row];
            for (int col = 0; col < currentRow.length; col++) {
                currentRow[col] = new BoardCell(new CellPosition(row, col), BoardCellState.CLOSED, false);
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

    public Integer getNumberOfMines() {
        int totalNumberOfCells = this.getRows() * this.getColumns();
        return Math.round((this.getDifficulty().minedCellsPercentage * totalNumberOfCells) / 100);
    }

    private void loadMinesInBoard() {
        int minedCells = 0;
        Random random = new Random();
        while (minedCells < this.getNumberOfMines()) {
            int randomRow = random.nextInt(this.getRows());
            int randomColumn = random.nextInt(this.getColumns());
            BoardCell currentCell = this.boardArea[randomRow][randomColumn];
            if (!currentCell.getIsMined()) {
                currentCell.setIsMined(true);
                minedCells++;
            }
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

    public BoardCell openBoardCell(CellPosition position) {
        BoardCell currentBoardCell = this.getBoardCell(position);
        if (currentBoardCell.getState().equals(BoardCellState.CLOSED)) {
            currentBoardCell.setState(BoardCellState.OPENED);
        }
        return currentBoardCell;
    }

    public BoardCell getBoardCell(CellPosition position) {
        try {
            return this.boardArea[position.getRow()][position.getColumn()];
        } catch (IndexOutOfBoundsException ioe) {
            return null;
        }
    }

    public List<BoardCell> getNeighborsOf(CellPosition cellPosition) {
        BoardCell currentBoardCell = this.getBoardCell(cellPosition);
        Map<String, CellPosition> neighborsMap = currentBoardCell.getNeighborsMap();

        return neighborsMap.values().stream()
                .map(this::getBoardCell)
                .filter(boardCell -> boardCell.isInBoard(this.getRows(), this.getColumns()))
                .collect(Collectors.toList());
    }

}
