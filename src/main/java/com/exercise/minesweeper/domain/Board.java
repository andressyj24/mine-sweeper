package com.exercise.minesweeper.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class Board {

    private BoardCell[][] boardArea;
    private Difficulty difficulty;
    private boolean mineOpened;
    private Integer totalEmptyCells;

    public Board(Integer rows, Integer columns, String difficulty) {
        boardArea = initializeBoard(rows, columns);
        this.difficulty = Difficulty.valueOf(difficulty);
        this.mineOpened = false;
        this.totalEmptyCells = (rows * columns) - this.getNumberOfMines();
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

    public Board openBoardCell(CellPosition position) {
        BoardCell currentBoardCell = this.getBoardCell(position);
        if (currentBoardCell.getState().equals(BoardCellState.CLOSED)) {
            currentBoardCell.setState(BoardCellState.OPENED);
            this.mineOpened = currentBoardCell.getIsMined();
            this.openNeighborCells(currentBoardCell);
        }
        return this;
    }

    private void openNeighborCells(BoardCell currentBoardCell) {
        if (!this.mineOpened) {
            List<BoardCell> neighbors = this.getNeighborsOf(currentBoardCell.getCellPosition());
            boolean allNeighborsAreSafe = neighbors.stream()
                    .noneMatch(BoardCell::getIsMined);
            if (allNeighborsAreSafe) {
                neighbors.forEach(n -> n.setState(BoardCellState.OPENED));
                this.totalEmptyCells = this.totalEmptyCells - neighbors.size() - 1;
            }
        }
    }

    public List<BoardCell> getNeighborsOf(CellPosition cellPosition) {
        BoardCell currentBoardCell = this.getBoardCell(cellPosition);
        Map<String, CellPosition> neighborsMap = currentBoardCell.getNeighborsMap();

        return neighborsMap.values().stream()
                .map(this::getBoardCell)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public BoardCell getBoardCell(CellPosition position) {
        try {
            return this.boardArea[position.getRow()][position.getColumn()];
        } catch (IndexOutOfBoundsException ioe) {
            return null;
        }
    }

    public List<BoardCell> getListOfBoardCells(List<CellPosition> positions) {
        return positions.stream().map(this::getBoardCell).collect(Collectors.toList());
    }

    public List<BoardCell> listAllBoardCells() {
        List<BoardCell> allCells = new ArrayList<>();
        Arrays.stream(this.boardArea).map(row -> allCells.addAll(List.of(row)));
        return allCells;
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

    @Override
    public String toString() {
        return Arrays.toString(this.boardArea);
    }

}
