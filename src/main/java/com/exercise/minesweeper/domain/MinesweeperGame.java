package com.exercise.minesweeper.domain;

public class MinesweeperGame {

    private NewGameRequest newGameRequest;
    private Board board;
    private Integer time;

    public MinesweeperGame(NewGameRequest newGameRequest) {
        this.newGameRequest = newGameRequest;
    }

    public NewGameRequest getNewGameRequest() {
        return newGameRequest;
    }

    public void setNewGameRequest(NewGameRequest newGameRequest) {
        this.newGameRequest = newGameRequest;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

}
