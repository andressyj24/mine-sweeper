package com.exercise.minesweeper.domain;

import com.exercise.minesweeper.ports.GameRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CacheGameRepository implements GameRepository {

    private Map<String, MinesweeperGame> gameDataMap = new HashMap<>();

    @Override
    public MinesweeperGame getGameById(String gameId) {
        return gameDataMap.get(gameId);
    }

    @Override
    public MinesweeperGame saveGame(MinesweeperGame minesweeperGame) {
        String generatedGameId = RandomStringUtils.randomAlphabetic(8);
        minesweeperGame.setGameId(generatedGameId);
        gameDataMap.put(generatedGameId, minesweeperGame);
        return minesweeperGame;
    }

    @Override
    public MinesweeperGame updateGame(MinesweeperGame game) {
        gameDataMap.put(game.getGameId(), game);
        return gameDataMap.get(game.getGameId());
    }

    @Override
    public List<MinesweeperGame> getGames() {
        return gameDataMap.values().stream().collect(Collectors.toList());
    }
}
