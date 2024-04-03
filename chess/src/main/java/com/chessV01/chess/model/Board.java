package com.chessV01.chess.model;

import com.chessV01.chess.entities.concretes.Piece;
import lombok.Data;

@Data
public class Board {
    private Piece[][] pieces = new Piece[8][8];

    public void addPiecesOnBoard(Piece piece, int x, int y){
        if(piece != null){
            this.pieces[x][y] = piece;
        }

    }

}
