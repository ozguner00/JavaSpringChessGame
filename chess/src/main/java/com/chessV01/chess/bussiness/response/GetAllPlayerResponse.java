package com.chessV01.chess.bussiness.response;

import com.chessV01.chess.entities.DTOs.PlayerDTO;
import com.chessV01.chess.entities.concretes.Player;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetAllPlayerResponse {
    public List<PlayerDTO> createResponse(List<Player> playerList) {
        return playerList.stream().map(PlayerDTO::new).collect(Collectors.toList());
    }

}

