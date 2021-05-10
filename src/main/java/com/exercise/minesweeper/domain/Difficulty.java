package com.exercise.minesweeper.domain;

public enum Difficulty {
    EASY(20),
    MEDIUM(50),
    HARD(80);

    public final Integer minedCellsPercentage;

    Difficulty(Integer minedCellsPercentage) {
        this.minedCellsPercentage = minedCellsPercentage;
    }
}
