package com.chessV01.chess.entities.concretes;

import com.chessV01.chess.model.Color;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "players")
@Data
@NoArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "score")
    private int score;

    @Enumerated(EnumType.STRING)
    @Column(name = "color")
    private Color color;

}
