package com.chessV01.chess.bussiness.concretes;

import com.chessV01.chess.bussiness.abstracts.BrokenPieceService;
import com.chessV01.chess.dataAccess.abstracts.BrokenPieceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrokenPieceManager implements BrokenPieceService {
    private BrokenPieceRepository brokenPieceRepository;

    @Autowired
    public void BrokenPieceManager(BrokenPieceRepository brokenPieceRepository){
        this.brokenPieceRepository = brokenPieceRepository;
    }
    public void deleteAllBrokenPieces() {
        brokenPieceRepository.deleteAll();
    }
}
