package com.chessV01.chess.entities.DTOs;

import com.chessV01.chess.entities.concretes.Piece;
import com.chessV01.chess.model.Color;
import com.chessV01.chess.model.PieceType;
import lombok.Data;

@Data
public class PieceDTO {
    private Long id;
    private int positionX;
    private int positionY;
    private Color color;
    private PieceType pieceType;

    public PieceDTO(Piece piece) {
        this.id = piece.getId();
        this.positionX = piece.getPositionX();
        this.positionY = piece.getPositionY();
        this.color = piece.getColor();
        this.pieceType = piece.getPieceType();
    }
}