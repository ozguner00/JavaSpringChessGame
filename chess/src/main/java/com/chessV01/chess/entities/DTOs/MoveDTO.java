package com.chessV01.chess.entities.DTOs;

import com.chessV01.chess.entities.concretes.Move;
import lombok.Data;

@Data
public class MoveDTO {
    private Long id;
    private Long gameId;
    private Long pieceId;
    private Long playerID;
    private String destination;

    public MoveDTO(Move move) {
        this.id = move.getId();
        this.gameId = move.getGameId();
        this.pieceId = move.getPieceId();
        this.playerID = move.getPlayerId();
        this.destination = move.getDestination();
    }
}
