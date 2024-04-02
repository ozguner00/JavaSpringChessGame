package com.chessV01.chess.bussiness.concretes;

import com.chessV01.chess.bussiness.abstracts.MoveService;
import com.chessV01.chess.bussiness.requests.EditPieceRequest;
import com.chessV01.chess.dataAccess.abstracts.MoveRepository;
import com.chessV01.chess.entities.DTOs.PieceDTO;
import com.chessV01.chess.entities.concretes.Move;
import com.chessV01.chess.entities.concretes.Piece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoveManager implements MoveService {

    private final ChessRuleManager chessRuleManager;
    private final MoveRepository moveRepository;
    private final PieceManager pieceManager;

    @Autowired
    public MoveManager(ChessRuleManager chessRuleManager, MoveRepository moveRepository,PieceManager pieceManager) {
        this.chessRuleManager = chessRuleManager;
        this.moveRepository = moveRepository;
        this.pieceManager = pieceManager;
    }


    public void makeMove(Long playerId, Long gameId, Long pieceID, int targetX, int targetY) {
        // Önce hamleyi kontrol et
        PieceDTO pieceDTO = pieceManager.getPieceById(pieceID);
        boolean isValidMove = chessRuleManager.validateMove(pieceDTO, targetX, targetY);
        boolean isDifferenColor = chessRuleManager.isDifferentColor();
        if (isValidMove) {
            // Eğer hamle geçerliyse, hamleyi veritabanına kaydet
            String destination = "" + pieceDTO.getPieceType() + pieceDTO.getPositionX() +
                    pieceDTO.getPositionY() + targetX + targetY;
            Move move = new Move(playerId, gameId, pieceID, destination);
            moveRepository.save(move);
            if(isDifferenColor){
                Long silinenTasID = 5L;
                pieceManager.movePieceToBrokenPiecesById(silinenTasID);
            }
            EditPieceRequest editPieceRequest = new EditPieceRequest(pieceID,targetX,targetY);
            pieceManager.editPiece(editPieceRequest);

        }
    }


}
