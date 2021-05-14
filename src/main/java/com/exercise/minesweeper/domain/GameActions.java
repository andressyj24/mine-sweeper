package com.exercise.minesweeper.domain;

public enum GameActions {
    OPEN("OPEN"),
    FLAG("FLAG");

    public String label;

    GameActions(String label) {
        this.label = label;
    }
}
