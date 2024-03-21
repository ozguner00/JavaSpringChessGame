package com.chessV01.chess.entities;

import com.chessV01.chess.pieces.Colour;
import com.chessV01.chess.pieces.PieceType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public abstract class Piece {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "yatay")
    private int x;

    @Column(name = "dikey")
    private int y;

    @Enumerated(EnumType.STRING)
    @Column(name = "colour")
    private Colour colour;

    @Enumerated(EnumType.STRING)
    @Column(name = "piece_type")
    private PieceType pieceType;


}


