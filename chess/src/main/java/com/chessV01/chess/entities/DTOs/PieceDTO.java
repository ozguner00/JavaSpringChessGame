package com.chessV01.chess.entities.DTOs;

import com.chessV01.chess.entities.concretes.Piece;
import com.chessV01.chess.model.Color;
import com.chessV01.chess.model.PieceType;
import lombok.Data;

@Data
public class PieceDTO {
    private Long id;
    private int sourceX;
    private int sourceY;
    private PieceType type;
    private Color color;
    private PieceType pieceType;

    public PieceDTO(Piece piece) {
        this.id = piece.getId();
        this.sourceX = piece.getSourceX();
        this.sourceY = piece.getSourceY();
        this.type = piece.getType();
        this.color = piece.getColor();
        this.pieceType = piece.getPieceType();
    }
}