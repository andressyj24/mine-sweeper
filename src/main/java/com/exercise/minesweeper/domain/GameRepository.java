package com.exercise.minesweeper.domain;

import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class GameRepository {
    public MinesweeperGame save(MinesweeperGame minesweeperGame) {
        UUID generatedUUID = UUID.randomUUID();
        minesweeperGame.setGameId(generatedUUID);
        return minesweeperGame;
    }
}
