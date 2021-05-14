package com.exercise.minesweeper.adapters;

import com.exercise.minesweeper.domain.MinesweeperGame;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetGamesResponse {

    private MinesweeperGame[] game;

    public static GetGamesResponse from (MinesweeperGame game) {
        GetGamesResponse getGamesResponse = new GetGamesResponse();
        getGamesResponse.setGame(ArrayUtils.toArray(game));
        return getGamesResponse;
    }

    public static GetGamesResponse from (List<MinesweeperGame> games) {
        GetGamesResponse getGamesResponse = new GetGamesResponse();
        getGamesResponse.setGame(games.toArray(MinesweeperGame[]::new));
        return getGamesResponse;
    }

}
