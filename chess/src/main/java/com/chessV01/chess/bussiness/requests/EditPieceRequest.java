package com.chessV01.chess.bussiness.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EditPieceRequest {
    private Long pieceId;
    private int newX;
    private int newY;
}

