package com.chessV01.chess.bussiness.abstracts;

import com.chessV01.chess.entities.concretes.Game;
import com.chessV01.chess.entities.concretes.Player;

public interface GameService {
    Game createGame(Long player1, Long player2);

}
