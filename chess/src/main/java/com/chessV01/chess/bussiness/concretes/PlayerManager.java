package com.chessV01.chess.bussiness.concretes;

import com.chessV01.chess.bussiness.abstracts.PlayerService;
import com.chessV01.chess.entities.DTOs.PlayerDTO;
import com.chessV01.chess.entities.concretes.Player;
import com.chessV01.chess.model.Color;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PlayerManager implements PlayerService {

    private final List<Player> players = new ArrayList<>(); // Oyuncuları tutan liste
    private long playerIdSequence = 1;

    @Override
    public PlayerDTO createPlayer(String name, String lastName, int score, Color color) {
        Player player = new Player();
        player.setId(playerIdSequence++);
        player.setName(name);
        player.setLastName(lastName);
        player.setScore(score);
        player.setColor(color);
        players.add(player);

        return new PlayerDTO(player);
    }

    @Override
    public List<PlayerDTO> getAllPlayers() {
        return players.stream().map(PlayerDTO::new).collect(Collectors.toList());
    }

}
