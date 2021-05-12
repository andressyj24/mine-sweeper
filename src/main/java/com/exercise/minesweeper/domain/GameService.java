package com.exercise.minesweeper.domain;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GameService {

    GameRepository gameRepository;

    public MinesweeperGame createNewGame(NewGameRequest newGameRequest) {
        MinesweeperGame minesweeperGame = new MinesweeperGame(newGameRequest);
        return gameRepository.save(minesweeperGame);
    }
}
