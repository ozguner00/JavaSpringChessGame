package com.chessV01.chess.entities.DTOs;

import com.chessV01.chess.entities.concretes.Move;
import lombok.Data;

@Data
public class MoveDTO {
    private Long id;
    private Long playerId;
    private Long gameId;
    private Long pieceId;

    public MoveDTO(Move move) {
        this.id = move.getId();
        this.playerId = move.getPlayer() != null ? move.getPlayer().getId() : null;
        this.gameId = move.getGame() != null ? move.getGame().getId() : null;
        this.pieceId = move.getPieceId();
    }
}
