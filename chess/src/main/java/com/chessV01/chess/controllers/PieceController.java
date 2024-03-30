package com.chessV01.chess.controllers;

import com.chessV01.chess.bussiness.abstracts.PieceService;
import com.chessV01.chess.bussiness.abstracts.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pieces")
public class PieceController {
    private final PieceService pieceService;

    @Autowired
    public PieceController(PieceService pieceService) {
        this.pieceService = pieceService;
    }


    @DeleteMapping("/move-to-broken/{id}")
    public ResponseEntity<String> movePieceToBrokenPieces(@PathVariable Long id) {
        try {
            pieceService.movePieceToBrokenPiecesById(id);
            return ResponseEntity.ok("Piece moved to broken pieces successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to move piece to broken pieces: " + e.getMessage());
        }
    }


}
