package com.chessV01.chess.bussiness.abstracts;

import com.chessV01.chess.entities.DTOs.PlayerDTO;
import com.chessV01.chess.model.Color;

import java.util.List;

public interface PlayerService {
    PlayerDTO createPlayer(String name, String lastName, int score, Color color);

    List<PlayerDTO> getAllPlayers();
}
