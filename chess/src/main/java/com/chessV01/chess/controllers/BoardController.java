package com.chessV01.chess.controllers;

import com.chessV01.chess.bussiness.concretes.BoardManager;
import com.chessV01.chess.entities.concretes.Piece;
import com.chessV01.chess.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
public class BoardController {

    private final BoardManager boardManager;

    @Autowired
    public BoardController(BoardManager boardManager) {
        this.boardManager = boardManager;
    }

    @GetMapping("/get")
    public ResponseEntity<Board> getBoard() {
        Board board = boardManager.getBoard();
        return ResponseEntity.status(HttpStatus.OK).body(board);
    }

    @GetMapping("/get2")
    public ResponseEntity<Piece> getBoard2() {
        Board board = boardManager.getBoard();
        Piece piece = board.getPieces()[1][1];
        return ResponseEntity.status(HttpStatus.OK).body(piece);
    }
}
