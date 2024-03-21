package com.chessV01.chess.controllers;

import com.chessV01.chess.bussiness.abstracts.GameService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class GameController {
    private GameService gameService;
    //TODO: get post patch
    @GetMapping("/PlayGame") //TODO: rest isimlendirme
    public String hello(){
        gameService.createGame();
        return "Oyun Oluşturuldu.";
    }

    @GetMapping("/GetBoard") //TODO:board  => get-board
    public String testGameBoard(){
        return gameService.getGameBoard();
    }

    @PostMapping("/moves")
    public String moves(int x, int y, int x2, int y2){  //TODO: move diye bir obje ile al

        String str = gameService.move(x,y,x2,y2) + gameService.getGameBoard();
        return str;
    }
}
