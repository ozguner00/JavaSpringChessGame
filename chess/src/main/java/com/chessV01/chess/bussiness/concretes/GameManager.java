package com.chessV01.chess.bussiness.concretes;

import com.chessV01.chess.bussiness.abstracts.GameService;
import com.chessV01.chess.entities.Game;
import com.chessV01.chess.entities.Piece;
import com.chessV01.chess.pieces.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GameManager implements GameService {
    private Game game = new Game();

    // 0 -- boş 1 -- aynı renk -1 farklı renk
    public int isCapacity(int x, int y, Piece piece){
        if(game.isCheckSide(x,y) != null && game.isCheckSide(x,y).getColour() == piece.getColour()){
            if(game.isCheckSide(x,y).getColour() != piece.getColour()){
                return -1;
                /*
                throw new IllegalArgumentException("kanka bu hamle yanlış"); //todo: how to write custom exception
                // TODO: controller advice nedir nasol yapılır

                 */
            }
            return 1;
        }
        else {
            return 0;
        }
    }
    public boolean isBoardCapacity(int x, int y){ //validateMove or check
        if(x > 7 || y > 7 || x < 0 || y < 0 ) return false;
        return true;
    }

    public void createGame(){
        for(int i = 0; i<8; i++){
          //  Piece piece = new Pawn(i,1,1, Colour.WHITE);
          //  Piece piece2 = new Pawn(i,6, Colour.BLACK);
            game.addPiece(piece);
            game.addPiece(piece2);
        }
        Piece piece = new Rook(0,0,Colour.WHITE); game.addPiece(piece);
        Piece piece2 = new Rook(0,7,Colour.BLACK); game.addPiece(piece2);
        Piece piece3 = new Rook(7,0,Colour.WHITE); game.addPiece(piece3);
        Piece piece4 = new Rook(7,7,Colour.BLACK); game.addPiece(piece4);

        Piece piece5 = new Knight(1,0,Colour.WHITE); game.addPiece(piece5);
        Piece piece6 = new Knight(6,0,Colour.WHITE); game.addPiece(piece6);
        Piece piece7 = new Knight(1,7,Colour.BLACK); game.addPiece(piece7);
        Piece piece8 = new Knight(6,7,Colour.BLACK); game.addPiece(piece8);

        Piece piece9 = new Bishop(2,0,Colour.WHITE); game.addPiece(piece9);
        Piece piece10 = new Bishop(5,0,Colour.WHITE); game.addPiece(piece10);
        Bishop piece11 = new Bishop(2,7,Colour.BLACK); game.addPiece(piece11);
        Piece piece12 = new Bishop(5,7,Colour.BLACK); game.addPiece(piece12);

        Piece piece13 = new King(3,0,Colour.WHITE); game.addPiece(piece13);
        Piece piece14 = new King(3,7,Colour.BLACK); game.addPiece(piece14);

        Queen piece15 = new Queen(4,0,Colour.WHITE); game.addPiece(piece15);
        Piece piece16 = new Queen(4,7,Colour.BLACK); game.addPiece(piece16);

    }

    @Override
    public String getGameBoard() {

        return game.getGameBoard();
    }

    @Override
    public boolean checkPiece(int x, int y){
        if(game.getOnePiece(x,y) != null) return true;

        return false;
    }

    @Override
    public String move(int x, int y, int x2, int y2){
        log.debug("Player moved initial position x: {}, y: {}, gitmesei istenen x2: {}, y2: {}", x, y, x2, y2); //TODO: loglamaya bakılacak
        //TODO: string pool compiler time =>
        /*
        game objesini alacaksın
        Move
         */
        String str = "Başarıyla hamle yaptınız. \n";
        String error = "Geçersiz hamle yapatınız.\n"; //TODO: constant
        if(!checkPiece(x,y)){
            return error + "Oynamak istediğiniz taş mevcut değil.\n";
        }
        if(!isBoardCapacity(x2,y2)){
            return error + "Taş mevcut ama hamleniz tahta sınırlarını aşıyor.\n";
        }
        game.move(x,y,x2,y2);
        return str;
    }
}
