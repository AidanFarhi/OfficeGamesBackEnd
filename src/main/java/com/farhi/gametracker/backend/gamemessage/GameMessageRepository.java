package com.farhi.gametracker.backend.gamemessage;

import com.farhi.gametracker.backend.player.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameMessageRepository extends JpaRepository<GameMessage, Long> {
    Optional<List<GameMessage>> findAllByReceivingPlayer(Player receivingPlayer);
    Optional<List<GameMessage>> findAllBySendingPlayer(Player sendingPlayer);
}
