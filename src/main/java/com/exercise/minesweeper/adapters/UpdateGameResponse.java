package com.exercise.minesweeper.adapters;

import lombok.Data;

@Data
public class UpdateGameResponse {

    private Integer gameId;
    private String gameStatus;
    private String username;

}
