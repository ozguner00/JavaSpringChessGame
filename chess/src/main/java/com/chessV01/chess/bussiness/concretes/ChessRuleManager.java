package com.chessV01.chess.bussiness.concretes;

import com.chessV01.chess.bussiness.abstracts.ChessRuleService;
import com.chessV01.chess.entities.Piece;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ChessRuleManager implements ChessRuleService {

    // Diğer metotlar burada

    public void applySpecialRules(Piece piece) {
        switch (piece.getType()) {
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
                // Bilinmeyen taş türü
                break;
        }
    }
    public boolean isMoveInBoardBounds(int targetX, int targetY) {
        // Tahtanın sınırlarını aşıp aşmadığını kontrol et
        // Örneğin, 1 ile 8 arasındaki sınırları kontrol etmek için:
        return targetX >= 0 && targetX <= 7 && targetY >= 0 && targetY <= 7;
    }

    public boolean isDifferentColourOrNull(Piece piece, Piece targetSquarePiece) {
        // Gidilen hücrede farklı renkte bir taş var mı veya hedef hücre boş mu kontrol et
        return targetSquarePiece == null || targetSquarePiece.getColour() != piece.getColour();
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

