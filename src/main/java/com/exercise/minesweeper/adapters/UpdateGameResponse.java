package com.exercise.minesweeper.adapters;

import com.exercise.minesweeper.domain.Board;
import com.exercise.minesweeper.domain.MinesweeperGame;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateGameResponse {

    private String gameId;
    private String username;
    private String gameStatus;
    private Board board;

    public static UpdateGameResponse from(MinesweeperGame game) {
        return new UpdateGameResponse(game.getGameId(), "andres",
                game.getStatus().label, game.getBoard());
    }

}
