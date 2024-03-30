package com.chessV01.chess.bussiness.concretes;

import com.chessV01.chess.bussiness.abstracts.GameService;
import com.chessV01.chess.dataAccess.abstracts.GameRepository;
import com.chessV01.chess.dataAccess.abstracts.PlayerRepository;
import com.chessV01.chess.entities.concretes.Game;
import com.chessV01.chess.entities.concretes.Player;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GameManager implements GameService {

    private final GameRepository gameRepository;
    private final PieceManager pieceManager;
    private final PlayerManager playerManager;

    @Autowired
    public GameManager(GameRepository gameRepository,PlayerManager playerManager,PieceManager pieceManager ) {
        this.gameRepository = gameRepository;
        this.pieceManager = pieceManager;
        this.playerManager = playerManager;
    }

    @Override
    public Game createGame(Long player1ID, Long player2ID) {
        pieceManager.initializePieces();
        Game game = new Game();
        game.setPlayer1(playerManager.getPlayerById(player1ID));
        game.setPlayer2(playerManager.getPlayerById(player2ID));
        return gameRepository.save(game);
    }




}

