package com.chessV01.chess.bussiness.concretes;

import com.chessV01.chess.bussiness.abstracts.PieceService;
import com.chessV01.chess.bussiness.requests.EditPieceRequest;
import com.chessV01.chess.dataAccess.abstracts.BrokenPieceRepository;
import com.chessV01.chess.dataAccess.abstracts.PieceRepository;
import com.chessV01.chess.entities.DTOs.PieceDTO;
import com.chessV01.chess.entities.concretes.BrokenPiece;
import com.chessV01.chess.entities.concretes.Piece;
import com.chessV01.chess.model.Color;
import com.chessV01.chess.model.PieceType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PieceManager implements PieceService {

    private PieceRepository pieceRepository;
    private BrokenPieceRepository brokenPieceRepository;
    @Autowired
    public PieceManager(PieceRepository pieceRepository,BrokenPieceRepository brokenPieceRepository){
        this.pieceRepository = pieceRepository;
        this.brokenPieceRepository = brokenPieceRepository;
    }
    public void initializePieces() {
        List<Piece> pieces = new ArrayList<>();

        // Beyaz piyonlar
        for (int i = 0; i < 8; i++) {
            Piece piece = new Piece();
            piece.setPositionX(i);
            piece.setPositionY(1);
            piece.setColor(Color.WHITE);
            piece.setPieceType(PieceType.PAWN);
            pieces.add(piece);
        }

        // Siyah piyonlar
        for (int i = 0; i < 8; i++) {
            Piece piece = new Piece();
            piece.setPositionX(i);
            piece.setPositionY(6);
            piece.setColor(Color.BLACK);
            piece.setPieceType(PieceType.PAWN);
            pieces.add(piece);
        }

        // Kaleler
        pieces.add(new Piece(0, 0, Color.WHITE, PieceType.ROOK));
        pieces.add(new Piece(7, 0, Color.WHITE, PieceType.ROOK));
        pieces.add(new Piece(0, 7, Color.BLACK, PieceType.ROOK));
        pieces.add(new Piece(7, 7, Color.BLACK, PieceType.ROOK));

// Filller
        pieces.add(new Piece(2, 0, Color.WHITE, PieceType.BISHOP));
        pieces.add(new Piece(5, 0, Color.WHITE, PieceType.BISHOP));
        pieces.add(new Piece(2, 7, Color.BLACK, PieceType.BISHOP));
        pieces.add(new Piece(5, 7, Color.BLACK, PieceType.BISHOP));

// Atlar
        pieces.add(new Piece(1, 0, Color.WHITE, PieceType.KNIGHT));
        pieces.add(new Piece(6, 0, Color.WHITE, PieceType.KNIGHT));
        pieces.add(new Piece(1, 7, Color.BLACK, PieceType.KNIGHT));
        pieces.add(new Piece(6, 7, Color.BLACK, PieceType.KNIGHT));

// Şahlar
        pieces.add(new Piece(4, 0, Color.WHITE, PieceType.KING));
        pieces.add(new Piece(4, 7, Color.BLACK, PieceType.KING));

// Vezirler
        pieces.add(new Piece(3, 0, Color.WHITE, PieceType.QUEEN));
        pieces.add(new Piece(3, 7, Color.BLACK, PieceType.QUEEN));

// Tüm taşları veritabanına kaydet
        pieceRepository.saveAll(pieces);

    }

    public void movePieceToBrokenPiecesById(Long pieceId) {
        // Veritabanından Piece'i al
        Piece piece = pieceRepository.findById(pieceId).orElse(null);

        // Piece bulunduysa ve BrokenPiece'e taşınamıyorsa
        if (piece != null) {
            // Piece'i sil
            pieceRepository.delete(piece);

            // Silinen Piece'in kopyasını oluşturarak BrokenPiece'e ekle
            BrokenPiece brokenPiece = new BrokenPiece();
            brokenPiece.setId(piece.getId());
            brokenPiece.setPositionX(piece.getPositionX());
            brokenPiece.setPositionY(piece.getPositionY());
            brokenPiece.setColor(piece.getColor());
            brokenPiece.setPieceType(piece.getPieceType());
            brokenPieceRepository.save(brokenPiece);
        }

    }

    public PieceDTO getPieceById(Long pieceId) {
        // Veritabanından PieceDTO'yu al
        Piece piece = pieceRepository.findById(pieceId).orElse(null);
        if (piece != null) {
            // Piece nesnesini PieceDTO'ya dönüştür
            return new PieceDTO(piece);
        }
        return null;
    }

    public void editPiece(EditPieceRequest editPieceRequest) {
        Long pieceId = editPieceRequest.getPieceId();
        int newX = editPieceRequest.getNewX();
        int newY = editPieceRequest.getNewY();

        // İlgili taşı veritabanından bul
        Piece piece = pieceRepository.findById(pieceId).orElse(null);
        if (piece == null) {
            // Taş bulunamadı, uygun bir hata işle
            throw new RuntimeException("Piece not found with id: " + pieceId);
        }

        // Yeni koordinatları ayarla
        piece.setPositionX(newX);
        piece.setPositionY(newY);

        // Güncellenmiş taşı veritabanına kaydet
        pieceRepository.save(piece);
    }

    public void deleteAllPieces() {
        pieceRepository.deleteAll();
    }


}
