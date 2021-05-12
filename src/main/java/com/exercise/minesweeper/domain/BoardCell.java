package com.exercise.minesweeper.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BoardCell {

    private CellPosition cellPosition;
    private BoardCellState state;
    private Boolean isMined;


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        BoardCell otherCell = (BoardCell) obj;
        return otherCell.getCellPosition().equals(this.cellPosition)
                && otherCell.getState().equals(this.state)
                && otherCell.getIsMined().equals(this.isMined);
    }

    @Override
    public String toString() {
        String stringValue;
        if (this.state.equals(BoardCellState.OPENED)) {
            stringValue = "?";
        } else if (this.state.equals(BoardCellState.FLAGGED)) {
            stringValue = "F";
        } else if (this.state.equals(BoardCellState.CLOSED) && !this.isMined) {
            stringValue = "O";
        } else {
            stringValue = "X";
        }

        return stringValue;
    }
}
