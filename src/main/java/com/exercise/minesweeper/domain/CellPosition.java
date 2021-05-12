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
}
