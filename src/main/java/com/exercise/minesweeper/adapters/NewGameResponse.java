package com.exercise.minesweeper.adapters;

import com.exercise.minesweeper.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewGameResponse {

    private String newGameId;
    private String username;
    private Board board;
}
