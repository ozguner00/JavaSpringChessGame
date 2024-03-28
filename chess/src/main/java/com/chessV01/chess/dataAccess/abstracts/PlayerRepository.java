package com.chessV01.chess.dataAccess.abstracts;

import com.chessV01.chess.entities.concretes.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long> {
}
