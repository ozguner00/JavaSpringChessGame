package com.chessV01.chess.bussiness.requests;

import com.chessV01.chess.model.Color;
import lombok.Data;

@Data
public class CreatePlayerRequest {
    private String name;
    private String lastName;
    private int score;
    private Color color;
}
