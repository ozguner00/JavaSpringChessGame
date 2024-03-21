package com.chessV01.chess.pieces;

import com.chessV01.chess.entities.Piece;

public class Queen extends Piece {


    public Queen(int x, int y, int id, Colour colour) {
        super(x, y, id, colour);
    }

    @Override
    public boolean isCheckMoveRules(int a, int b) {
        return true;
    }

    @Override
    public String toString(){
        String str  = "Queen" + " " + getColour() + " x:" + getX() + " y:" + getY();
        return str;
    }

    public String getPieceName(){
        return "Queen";
    }

}
