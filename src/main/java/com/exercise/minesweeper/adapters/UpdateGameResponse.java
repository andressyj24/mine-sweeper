package com.exercise.minesweeper.adapters;

import com.exercise.minesweeper.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateGameResponse {

    private Integer gameId;
    private String username;
    private String gameStatus;
    private Board board;

}
