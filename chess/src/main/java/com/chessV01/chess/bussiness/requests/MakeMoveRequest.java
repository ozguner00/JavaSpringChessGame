package com.chessV01.chess.bussiness.requests;

import lombok.Data;

@Data
public class MakeMoveRequest {
    private Long playerId;
    private Long gameId;
    private Long pieceId;
    private int targetX;
    private int targetY;
}