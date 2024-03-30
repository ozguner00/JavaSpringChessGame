package com.chessV01.chess.bussiness.concretes;

import com.chessV01.chess.bussiness.abstracts.PlayerService;
import com.chessV01.chess.dataAccess.abstracts.PlayerRepository;
import com.chessV01.chess.entities.DTOs.PlayerDTO;
import com.chessV01.chess.entities.concretes.Player;
import com.chessV01.chess.model.Color;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PlayerManager implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;
    @Override
    public PlayerDTO createPlayer(String name, String lastName, int score, Color color) {
        Player player = new Player();
        player.setName(name);
        player.setLastName(lastName);
        player.setScore(score);
        player.setColor(color);
        playerRepository.save(player);

        return new PlayerDTO(player);
    }

    @Override
    public List<PlayerDTO> getAllPlayers() {
        List<Player> players = playerRepository.findAll();
        return players.stream().map(PlayerDTO::new).collect(Collectors.toList());
    }

    @Override
    public void deletePlayerById(Long id) {
        playerRepository.deleteById(id);
    }

    @Override
    public PlayerDTO getDeletedPlayerById(Long id) {
        Optional<Player> playerOptional = playerRepository.findById(id);
        if (playerOptional.isPresent()) {
            Player deletedPlayer = playerOptional.get();
            playerRepository.deleteById(id);
            return new PlayerDTO(deletedPlayer);
        } else {
            throw new EntityNotFoundException("Player with ID " + id + " not found.");
        }
    }

    @Override
    public PlayerDTO editPlayerScore(Long id, int newScore) {
        Optional<Player> playerOptional = playerRepository.findById(id);
        if (playerOptional.isPresent()) {
            Player player = playerOptional.get();
            player.setScore(newScore);
            playerRepository.save(player);
            return new PlayerDTO(player);
        } else {
            throw new EntityNotFoundException("Player with ID " + id + " not found.");
        }
    }

    @Override
    public List<PlayerDTO> getTop10Players() {
        List<Player> topPlayers = playerRepository.findTop10ByOrderByScoreDesc();
        return topPlayers.stream().map(PlayerDTO::new).collect(Collectors.toList());
    }

    @Override
    public Player getPlayerById(Long playerId){
        return playerRepository.findById(playerId).orElse(null);
    }
}
