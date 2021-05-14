package com.exercise.minesweeper.domain;

import com.exercise.minesweeper.adapters.NewGameRequest;
import com.exercise.minesweeper.adapters.UpdateGameRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@AllArgsConstructor
public class GameService {

    CacheGameRepository gameRepository;

    public MinesweeperGame createNewGame(NewGameRequest request) {
        MinesweeperGame minesweeperGame = new MinesweeperGame(request);
        return gameRepository.saveGame(minesweeperGame);
    }

    public MinesweeperGame updateGame(UpdateGameRequest request, String gameId) {
        MinesweeperGame minesweeperGame = gameRepository.getGameById(gameId);
        CellPosition cellPosition = new CellPosition(request.getRow(), request.getColumn());
        GameActions action = GameActions.valueOf(request.getAction().toUpperCase(Locale.ROOT));
        switch (action) {
            case OPEN:
                return minesweeperGame.openCell(cellPosition);
            case FLAG:
                return minesweeperGame.flagCell(cellPosition);
            default:
                return minesweeperGame;
        }
    }

    public MinesweeperGame getGameById(String gameId) {
        return gameRepository.getGameById(gameId);
    }
}
