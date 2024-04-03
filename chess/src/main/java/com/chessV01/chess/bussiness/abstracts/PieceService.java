package com.chessV01.chess.bussiness.abstracts;

import com.chessV01.chess.bussiness.requests.EditPieceRequest;
import com.chessV01.chess.entities.DTOs.PieceDTO;
import com.chessV01.chess.entities.concretes.Piece;

public interface PieceService {
    void movePieceToBrokenPiecesById(Long pieceId);

    PieceDTO getPieceById(Long pieceId);

    void deleteAllPieces();

    void editPiece(EditPieceRequest editPieceRequest);

    public Piece getPieceByCoordinates(int x, int y);

}
