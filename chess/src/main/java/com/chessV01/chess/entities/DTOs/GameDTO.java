package com.chessV01.chess.entities.DTOs;

import com.chessV01.chess.entities.concretes.Game;
import lombok.Data;

@Data
public class GameDTO {
    private Long id;
    private Long player1Id;
    private Long player2Id;

    public GameDTO(Game game) {
        this.id = game.getId();
        this.player1Id = game.getPlayer1() != null ? game.getPlayer1().getId() : null;
        this.player2Id = game.getPlayer2() != null ? game.getPlayer2().getId() : null;
    }
}
