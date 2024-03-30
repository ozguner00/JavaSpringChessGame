package com.chessV01.chess.entities.concretes;

import com.chessV01.chess.model.Color;
import com.chessV01.chess.model.PieceType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@Table(name = "brokenPieces")
public class BrokenPiece{

    @Id
    private Long id;

    @Column(name = "positionX")
    private int positionX;

    @Column(name = "positionY")
    private int positionY;

    @Enumerated(EnumType.STRING)
    @Column(name = "color")
    private Color color;

    @Enumerated(EnumType.STRING)
    @Column(name = "piece_type")
    private PieceType pieceType;

}
