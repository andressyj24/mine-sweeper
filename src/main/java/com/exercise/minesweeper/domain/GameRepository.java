package com.exercise.minesweeper.domain;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Repository;

@Repository
public class GameRepository {
    public MinesweeperGame save(MinesweeperGame minesweeperGame) {
        String generatedGameId = RandomStringUtils.randomAlphabetic(8);
        minesweeperGame.setGameId(generatedGameId);
        return minesweeperGame;
    }
}
