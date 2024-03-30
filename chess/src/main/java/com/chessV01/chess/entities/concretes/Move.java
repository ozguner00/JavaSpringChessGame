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

    @ManyToOne
    @JoinColumn(name = "player.id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "game.id")
    private Game game;

    @Column(name = "piece.id")
    private Long pieceId;

}
