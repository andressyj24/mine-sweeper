package com.exercise.minesweeper.domain;

public enum GameStatus {
    IN_PROGRESS("IN_PROGRESS"),
    OVER("OVER"),
    WIN("WIN");

    public final String label;

    GameStatus(String label) {
        this.label = label;
    }
}
