package com.chessV01.chess.entities.DTOs;

import com.chessV01.chess.entities.concretes.Player;
import com.chessV01.chess.model.Color;
import lombok.Data;

@Data
public class PlayerDTO {
    private Long id;
    private String name;
    private String lastName;
    private int score;
    private Color color;

    public PlayerDTO(Player player) {
        this.id = player.getId();
        this.name = player.getName();
        this.lastName = player.getLastName();
        this.score = player.getScore();
        this.color = player.getColor();
    }
}
