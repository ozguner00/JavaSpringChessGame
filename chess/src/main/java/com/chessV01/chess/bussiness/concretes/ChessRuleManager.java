package com.chessV01.chess.bussiness.concretes;

import com.chessV01.chess.bussiness.abstracts.ChessRuleService;
import com.chessV01.chess.entities.DTOs.PieceDTO;
import com.chessV01.chess.entities.concretes.Piece;
import com.chessV01.chess.model.Board;
import com.chessV01.chess.model.Color;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChessRuleManager implements ChessRuleService {
    private BoardManager boardManager;

    @Autowired
    public ChessRuleManager(BoardManager boardManager){
        this.boardManager = boardManager;
    }

    // Board hareket kontrolü için burada kullanılacak.
    // Board ile hareket kontrolü yaptıktan sonra hareket eden taşı kaldır yeni yerine ekle, kırılan taşı kaldır.
    // Tahta için her seferinde database bağlanma edit işlemleri burada yap.

    public boolean validateMove(PieceDTO pieceDTO, int targetX, int targetY){ //test
        Piece targetPiece = boardManager.getBoard().getPieces()[targetX][targetY];

        boolean isMoveInBoard = isMoveInBoardBounds(targetX,targetY); // tahta sınırlarına bak.
        boolean isDifferentColor = isDifferentColor(pieceDTO,targetX,targetY); // farklı renkte mi
        boolean isSquareEmpty = isSquareEmpty(boardManager.getBoard().getPieces()[targetX][targetY]); // Son kare boş mu?

        if(isMoveInBoard && (isSquareEmpty || isDifferentColor)){
            if(applySpecialRules(pieceDTO)){
                //Son aşamada hareket doğruysa, tasarruf için database bağlanmak yerine boardı elle değiştiriyoruz.
                this.boardManager.getBoard().getPieces()[targetX][targetY] = this.boardManager.getBoard().getPieces()[pieceDTO.getPositionX()][pieceDTO.getPositionY()];
                return true;
            }
            return applySpecialRules(pieceDTO);
        }
        return false;
    }

    public void updateBoard(Piece piece){

    }

    public boolean isMoveInBoardBounds(int targetX, int targetY) { // Tahtanın sınırlarını aşıp aşmadığını kontrol eder.
        return targetX >= 0 && targetX <= 7 && targetY >= 0 && targetY <= 7;
    }

    public boolean isSquareEmpty(Piece targetSquarePiece) { // Hedef hücre boş mu kontrol eder.
        if(targetSquarePiece == null) return true;
        return false;
    }

    public boolean isDifferentColor(PieceDTO pieceDTO, int targetX, int targetY){ // hedef hücre ve oynanan taş.
        return true;
    }

    public boolean applySpecialRules(PieceDTO piece) {
        switch (piece.getPieceType()) {
            case PAWN:
                return applyPawnRules(piece);
            case ROOK:
                return applyRookRules(piece);
            case KNIGHT:
                return applyKnightRules(piece);
            case BISHOP:
                return applyBishopRules(piece);
            case QUEEN:
                return applyQueenRules(piece);
            case KING:
                return applyKingRules(piece);
            default:
                return false;
        }
    }

    private boolean applyPawnRules(PieceDTO piece) {
        return true;
    }

    private boolean applyRookRules(PieceDTO piece) {
        return true;
    }

    private boolean applyKnightRules(PieceDTO piece) {
        return true;
    }

    private boolean applyBishopRules(PieceDTO piece) {
        return true;
    }

    private boolean applyQueenRules(PieceDTO piece) {
        return true;
    }

    private boolean applyKingRules(PieceDTO piece) {
        return true;
    }
}

