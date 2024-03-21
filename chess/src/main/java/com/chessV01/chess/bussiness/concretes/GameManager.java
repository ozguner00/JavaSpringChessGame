package com.chessV01.chess.bussiness.concretes;

import com.chessV01.chess.bussiness.abstracts.GameService;
import com.chessV01.chess.entities.Game;
import com.chessV01.chess.entities.Piece;
import com.chessV01.chess.entities.Player;
import com.chessV01.chess.model.Colour;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Slf4j
public class GameManager implements GameService{

    private List<Game> games;

    public GameManager() {
        this.games = new ArrayList<>();
    }

    public void createGame(Player player1, Player player2) {
        // Yeni bir oyun oluştur ve oyuncuları ekleyerek listeye ekle
        Game game = new Game();
        game.setPlayer1(player1);
        game.setPlayer2(player2);
    }

    public List<Game> getAllGames() {
        // Tüm oyunları getir
        return games;
    }

    public Game getGameById(Long id) {
        // Belirli bir ID'ye sahip oyunu getir
        for (Game game : games) {
            if (game.getId().equals(id)) {
                return game;
            }
        }
        return null; // Belirli bir ID'ye sahip oyun bulunamazsa null döndür
    }

    public void updateGame(Game game) {
        // Bir oyunu güncelle
        // (Gerekirse)
    }

    public void deleteGame(Long id) {
        // Belirli bir ID'ye sahip oyunu sil
        for (Game game : games) {
            if (game.getId().equals(id)) {
                games.remove(game);
                break;
            }
        }
    }
}
