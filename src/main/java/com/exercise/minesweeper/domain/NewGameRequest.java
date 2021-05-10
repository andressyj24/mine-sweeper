package com.exercise.minesweeper.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewGameRequest {

    private Integer rows;
    private Integer columns;
    private Integer timer;

}
