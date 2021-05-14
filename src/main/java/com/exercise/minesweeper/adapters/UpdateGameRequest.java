package com.exercise.minesweeper.adapters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateGameRequest {
    private Integer row;
    private Integer column;
    private String action;
}
