package com.exercise.minesweeper.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BoardCell {

    private Integer row;
    private Integer column;
    private BoardCellState state;
    private Boolean isMined;

    @Override
    public String toString() {
        String stringValue;
        if (this.state.equals(BoardCellState.COVERED)) {
            stringValue = "?";
        } else if (this.state.equals(BoardCellState.FLAGGED)) {
            stringValue = "F";
        } else if (this.state.equals(BoardCellState.UNCOVERED) && !this.isMined) {
            stringValue = "O";
        } else {
            stringValue = "X";
        }

        return stringValue;
    }
}
