package com.chessV01.chess.bussiness.concretes;

import com.chessV01.chess.bussiness.abstracts.ChessRuleService;
import com.chessV01.chess.entities.DTOs.PieceDTO;
import com.chessV01.chess.entities.concretes.Piece;
import com.chessV01.chess.model.Board;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
public class ChessRuleManager implements ChessRuleService {

    public void applySpecialRules(Piece piece) {
        switch (piece.getPieceType()) {
            case PAWN:
                applyPawnRules(piece);
                break;
            case ROOK:
                applyRookRules(piece);
                break;
            case KNIGHT:
                applyKnightRules(piece);
                break;
            case BISHOP:
                applyBishopRules(piece);
                break;
            case QUEEN:
                applyQueenRules(piece);
                break;
            case KING:
                applyKingRules(piece);
                break;
            default:
                break;
        }
    }

    public boolean validateMove(PieceDTO piece, int targetX, int targetY){ //test
        return true;
    }
    public boolean isMoveInBoardBounds(int targetX, int targetY) {
        // Tahtanın sınırlarını aşıp aşmadığını kontrol et
        // Örneğin, 1 ile 8 arasındaki sınırları kontrol etmek için:
        return targetX >= 0 && targetX <= 7 && targetY >= 0 && targetY <= 7;
    }

    // Hedef hücre boş mu kontrol eden fonksiyon
    public boolean isSquareEmpty(Piece targetSquarePiece) {
        return targetSquarePiece == null;
    }

    // Farklı renkte taş var mı kontrol eden fonksiyon.
   /* public boolean isDifferentColor(PieceDTO piece, Piece targetSquarePiece) {
        return targetSquarePiece != null && targetSquarePiece.getColor() != piece.getColor();
    }?/
    */

    public boolean isDifferentColor(){
        return true;
    }
    private void applyPawnRules(Piece piece) {
        // Piyon için özel kuralları uygula
    }

    private void applyRookRules(Piece piece) {
        // Kale için özel kuralları uygula
    }

    private void applyKnightRules(Piece piece) {
        // At için özel kuralları uygula
    }

    private void applyBishopRules(Piece piece) {
        // Fil için özel kuralları uygula
    }

    private void applyQueenRules(Piece piece) {
        // Vezir için özel kuralları uygula
    }

    private void applyKingRules(Piece piece) {
        // Şah için özel kuralları uygula
    }
}

