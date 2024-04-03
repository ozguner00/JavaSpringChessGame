package com.chessV01.chess.bussiness.concretes;

import com.chessV01.chess.bussiness.abstracts.BoardService;
import com.chessV01.chess.entities.concretes.Piece;
import com.chessV01.chess.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardManager implements BoardService {

    private final PieceManager pieceManager;
    private Board board;

    @Autowired
    public BoardManager(PieceManager pieceManager) {
        this.pieceManager = pieceManager;
        this.board = new Board();
    }

    public Board getBoard(){
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Piece piece = pieceManager.getPieceByCoordinates(x, y);
                if(piece != null){
                    this.board.addPiecesOnBoard(piece, x, y);
                }
            }
        }
        return this.board;
    }


}
