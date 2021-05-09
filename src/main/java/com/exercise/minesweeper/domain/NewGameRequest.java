package com.exercise.minesweeper.domain;

import lombok.Data;

@Data
public class NewGameRequest {

    private Integer rows;
    private Integer columns;
    private Integer timer;

}
