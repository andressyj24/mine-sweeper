package com.exercise.minesweeper.domain;

public enum CardinalDirections {
    NORTH("NORTH", new CellPosition(-1, 0)),
    NORTH_EAST("NORTH_EAST", new CellPosition(-1, 1)),
    EAST("EAST", new CellPosition(0, 1)),
    SOUTH_EAST("SOUTH_EAST", new CellPosition(1, 1)),
    SOUTH("SOUTH", new CellPosition(1, 0)),
    SOUTH_WEST("SOUTH_WEST", new CellPosition(1, -1)),
    WEST("WEST", new CellPosition(0, -1)),
    NORTH_WEST("NORTH_WEST", new CellPosition(-1, -1));

    public final String name;
    public final CellPosition cellPosition;

    CardinalDirections(String name, CellPosition cellPosition) {
        this.name = name;
        this.cellPosition = cellPosition;
    }
}
