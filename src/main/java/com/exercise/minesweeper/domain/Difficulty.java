package com.exercise.minesweeper.domain;

public enum Difficulty {
    ZERO(0),
    EASY(20),
    MEDIUM(50),
    HARD(80);

    public final Integer minedCellsPercentage;

    Difficulty(Integer minedCellsPercentage) {
        this.minedCellsPercentage = minedCellsPercentage;
    }
}
