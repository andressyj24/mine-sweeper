package com.exercise.minesweeper.domain;

import com.exercise.minesweeper.adapters.NewGameRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GameService {

    CacheGameRepository gameRepository;

    public MinesweeperGame createNewGame(NewGameRequest newGameRequest) {
        MinesweeperGame minesweeperGame = new MinesweeperGame(newGameRequest);
        return gameRepository.saveGame(minesweeperGame);
    }

    public MinesweeperGame getGameById(String gameId) {
        return gameRepository.getGameById(gameId);
    }
}
