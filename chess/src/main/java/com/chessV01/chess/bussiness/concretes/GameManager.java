package com.chessV01.chess.bussiness.concretes;

import com.chessV01.chess.bussiness.abstracts.GameService;
import com.chessV01.chess.dataAccess.abstracts.GameRepository;
import com.chessV01.chess.entities.concretes.Game;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameManager implements GameService {

    private final GameRepository gameRepository;
    private final PieceManager pieceManager;
    private final PlayerManager playerManager;
    private final BrokenPieceManager brokenPieceManager;


    @Autowired
    public GameManager(GameRepository gameRepository,PlayerManager playerManager,PieceManager pieceManager,BrokenPieceManager brokenPieceManager ) {
        this.gameRepository = gameRepository;
        this.pieceManager = pieceManager;
        this.playerManager = playerManager;
        this.brokenPieceManager = brokenPieceManager;
    }

    @Override
    public Game createGame(Long player1ID, Long player2ID) {
        // Önceki oyunu sil
        pieceManager.deleteAllPieces();
        brokenPieceManager.deleteAllBrokenPieces();

        pieceManager.initializePieces();
        Game game = new Game();
        game.setPlayer1(playerManager.getPlayerById(player1ID));
        game.setPlayer2(playerManager.getPlayerById(player2ID));
        return gameRepository.save(game);
    }

}

