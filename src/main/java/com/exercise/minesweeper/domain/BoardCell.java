package com.exercise.minesweeper.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

import static com.exercise.minesweeper.domain.CardinalDirections.*;


@Data
@AllArgsConstructor
public class BoardCell {

    private CellPosition cellPosition;
    private BoardCellState state;
    private Boolean isMined;

    public Map<String, CellPosition> getNeighborsMap() {
        Map<String, CellPosition> neighborsMap = new HashMap<>();
        neighborsMap.put(NORTH.name, this.getNeighborAt(NORTH.cellPosition));
        neighborsMap.put(NORTH_EAST.name, this.getNeighborAt(NORTH_EAST.cellPosition));
        neighborsMap.put(EAST.name, this.getNeighborAt(EAST.cellPosition));
        neighborsMap.put(SOUTH_EAST.name, this.getNeighborAt(SOUTH_EAST.cellPosition));
        neighborsMap.put(SOUTH.name, this.getNeighborAt(SOUTH.cellPosition));
        neighborsMap.put(SOUTH_WEST.name, this.getNeighborAt(SOUTH_WEST.cellPosition));
        neighborsMap.put(WEST.name, this.getNeighborAt(WEST.cellPosition));
        neighborsMap.put(NORTH_WEST.name, this.getNeighborAt(NORTH_WEST.cellPosition));
        return neighborsMap;
    }

    public boolean isInBoard(int maxRows, int maxColumn) {
        return this.cellPosition.isValid() && this.cellPosition.getRow() < maxRows && this.cellPosition.getColumn() < maxColumn;
    }

    private CellPosition getNeighborAt(CellPosition neighbor) {
        return this.cellPosition.getPositionAt(neighbor);
    }

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
            stringValue = this.cellPosition.getRow() + ":" + this.cellPosition.getColumn();
        } else {
            stringValue = "X";
        }

        return stringValue;
    }
}
