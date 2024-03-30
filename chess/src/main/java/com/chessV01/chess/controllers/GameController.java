package com.chessV01.chess.controllers;

import com.chessV01.chess.bussiness.concretes.GameManager;
import com.chessV01.chess.bussiness.concretes.PieceManager;
import com.chessV01.chess.bussiness.concretes.PlayerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class GameController {
    private final GameManager gameManager;

    @Autowired
    public GameController(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @PostMapping("/start")
    public String startNewGame(@RequestParam Long player1ID, @RequestParam Long player2ID) {
        Long gameId = gameManager.createGame(player1ID,player2ID).getId();
        return "New game started with ID: " + gameId;
    }

}
