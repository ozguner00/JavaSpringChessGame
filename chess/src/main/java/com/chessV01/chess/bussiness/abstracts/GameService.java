package com.chessV01.chess.bussiness.abstracts;

import com.chessV01.chess.entities.Piece;

public interface GameService {
     int isCapacity(int x, int y, Piece piece);
     boolean isBoardCapacity(int x, int y);

     void createGame();
     String getGameBoard();

     String move(int x, int y, int x2, int y2);
     boolean checkPiece(int x, int y);
}
