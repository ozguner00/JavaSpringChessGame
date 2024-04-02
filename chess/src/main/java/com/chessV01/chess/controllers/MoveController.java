package com.chessV01.chess.controllers;

import com.chessV01.chess.bussiness.concretes.MoveManager;
import com.chessV01.chess.bussiness.requests.MakeMoveRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/move")
public class MoveController {

    private final MoveManager moveManager;

    @Autowired
    public MoveController(MoveManager moveManager) {
        this.moveManager = moveManager;
    }

    @PostMapping("/move")
    public ResponseEntity<String> makeMove(@RequestBody MakeMoveRequest request) {
        try {
            moveManager.makeMove(request.getPlayerId(), request.getGameId(), request.getPieceId(), request.getTargetX(), request.getTargetY());
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Move successfully made.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to make move: " + e.getMessage());
        }
    }
}

