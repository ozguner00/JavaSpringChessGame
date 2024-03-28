package com.chessV01.chess.controllers;

import com.chessV01.chess.bussiness.abstracts.PlayerService;
import com.chessV01.chess.bussiness.requests.CreatePlayerRequest;
import com.chessV01.chess.entities.DTOs.PlayerDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/msg")
    public String msg(){return "Program ayaga kalktı.";}

    @PostMapping("/add-player")
    public ResponseEntity<String> createPlayer(@RequestBody CreatePlayerRequest request) {
        try {
            PlayerDTO createdPlayer = playerService.createPlayer(request.getName(), request.getLastName(),
                    request.getScore(), request.getColor());
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Player created with ID: " + createdPlayer.getId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to create player: " + e.getMessage());
        }
    }

    @GetMapping("/players")
    public ResponseEntity<List<PlayerDTO>> getAllPlayers() {
        List<PlayerDTO> allPlayers = playerService.getAllPlayers();
        return ResponseEntity.ok().body(allPlayers);
    }


}
