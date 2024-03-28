package com.chessV01.chess.dataAccess.abstracts;

import com.chessV01.chess.entities.concretes.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game,Long> {
}
