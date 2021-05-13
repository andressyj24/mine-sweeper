package com.exercise.minesweeper.domain;

public enum GameStatus {
    IN_PROGRESS("IN_PROGRESS"),
    OVER("OVER");

    public final String label;

    GameStatus(String label) {
        this.label = label;
    }
}
