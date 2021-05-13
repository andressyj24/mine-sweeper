package com.exercise.minesweeper.adapters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewGameRequest {

    private Integer rows;
    private Integer columns;
    private Integer timer;
    private String difficulty;

}
