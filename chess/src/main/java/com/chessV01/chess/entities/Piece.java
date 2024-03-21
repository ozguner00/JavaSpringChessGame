package com.chessV01.chess.entities;

import com.chessV01.chess.model.Color;
import com.chessV01.chess.model.PieceType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "pieces")
@NoArgsConstructor
public class Piece {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "sourceX")
    private int sourceX;

    @Column(name = "sourceY")
    private int sourceY;

    @Column(name = "type")
    private PieceType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "color")
    private Color color;

    @Enumerated(EnumType.STRING)
    @Column(name = "piece_type")
    private PieceType pieceType;

}


