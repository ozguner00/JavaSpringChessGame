package com.chessV01.chess.entities;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "games")
@Data
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player1_id")
    private Player player1;

    @ManyToOne
    @JoinColumn(name = "player2_id")
    private Player player2;

    private Piece[][] gameBoard = new Piece[8][8];


    public void setGameBoard(Piece[][] gameBoard) {
        this.gameBoard = gameBoard;
    }

    public Piece isCheckSide(int x, int y){
        return this.gameBoard[x][y];
    }

    public void addPiece(Piece piece){
        this.gameBoard[piece.getX()][piece.getY()] = piece;
    }

    public String getGameBoard() {
        String str = "";
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8 ; j++){
                if(gameBoard[i][j] != null)
                    str+= gameBoard[i][j].toString() + " \n";
            }
        }

        String board  ="";
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8 ; j++){
                if(gameBoard[j][i] != null)
                    board += gameBoard[j][i].getColour() + " " + gameBoard[j][i].getPieceName() + " | ";
                else{
                    board += "X             | ";
                }
            }
            board += "\n";
        }
        return board;
    }

    public Piece getOnePiece(int x, int y){
        return gameBoard[x][y];
    }
    //Move null kontrolleri yukarıda yapılıyor.
    public void move (int x, int y, int x2, int y2){
        gameBoard[x][y].setX(x2);
        gameBoard[x][y].setY(y2);
        gameBoard[x2][y2] = gameBoard[x][y]; // silme işlemi yok taş varsa üstüne yazar
        gameBoard[x][y] = null;
    }
    /*
    //TODO:
    oop abstaction => oyun => game içinde sanallaştırılabilir => state tutulur ve tahtanın fotosu çekilir (son hali)
    => işlem yapılacaksa bunu serviste yapmak lazım


     */
}
