package com.chessV01.chess.entities.concretes;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "moves")
@Data
@NoArgsConstructor
public class Move {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "game_id")
    private Long gameId;

    @Column(name = "player_id")
    private Long playerId;

    @Column(name = "piece_id")
    private Long pieceId;

    @Column(name = "destination")
    private String destination;


    public Move(Long gameId, Long playerId, Long pieceId, String destination) {
        this.playerId = playerId;
        this.gameId = gameId;
        this.pieceId = pieceId;
        this.destination = destination;
    }
}
