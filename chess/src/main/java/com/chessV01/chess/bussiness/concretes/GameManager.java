package com.chessV01.chess.bussiness.concretes;

import com.chessV01.chess.bussiness.abstracts.GameService;
import com.chessV01.chess.dataAccess.abstracts.GameRepository;
import com.chessV01.chess.entities.concretes.Game;
import com.chessV01.chess.entities.concretes.Player;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GameManager implements GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameManager(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game createGame(Player player1, Player player2) {
        Game game = new Game();
        game.setPlayer1(player1);
        game.setPlayer2(player2);
        return gameRepository.save(game);
    }



}

