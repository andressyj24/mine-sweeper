package com.exercise.minesweeper.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CellPosition {

    Integer row;
    Integer column;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        CellPosition otherPosition = (CellPosition) obj;
        return otherPosition.getRow().equals(this.row) && otherPosition.getColumn().equals(this.column);
    }

    public boolean isValid() {
        return this.row > 0 && this.column > 0;
    }

    public CellPosition getPositionAt(CellPosition nextPosition) {
        int targetRow = row + nextPosition.getRow();
        int targetColumn = column + nextPosition.getColumn();
        return new CellPosition(targetRow, targetColumn);
    }
}
