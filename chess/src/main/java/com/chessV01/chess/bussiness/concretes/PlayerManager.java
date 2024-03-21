package com.chessV01.chess.bussiness.concretes;

import com.chessV01.chess.bussiness.abstracts.PlayerService;
import com.chessV01.chess.entities.Player;
import com.chessV01.chess.model.Color;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
@Slf4j
public class PlayerManager implements PlayerService {

    private List<Player> players;

    public PlayerManager() {
        this.players = new ArrayList<>();
    }

    public void createPlayer(String name, String lastName, int score, Color color) {

        Player player = new Player();
        player.setName(name);
        player.setLastName(lastName);
        player.setScore(score);
        player.setColor(color);
        players.add(player);
    }

    public void addPlayer(Player player) {
        // Yeni bir oyuncu ekle
        players.add(player);
    }

    public List<Player> getAllPlayers() {
        // Tüm oyuncuları getir
        return players;
    }

    public Player getPlayerById(Long id) {
        // Belirli bir ID'ye sahip oyuncuyu getir
        for (Player player : players) {
            if (player.getId().equals(id)) {
                return player;
            }
        }
        return null; // Belirli bir ID'ye sahip oyuncu bulunamazsa null döndür
    }

    public void updatePlayer(Player player) {
        // Bir oyuncuyu güncelle
        // (Gerekirse)
    }

    public void deletePlayer(Long id) {
        // Belirli bir ID'ye sahip oyuncuyu sil
        for (Player player : players) {
            if (player.getId().equals(id)) {
                players.remove(player);
                break;
            }
        }
    }
}
