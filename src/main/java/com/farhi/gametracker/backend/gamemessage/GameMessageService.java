package com.farhi.gametracker.backend.gamemessage;

import com.farhi.gametracker.backend.json.GameMessageResponse;
import com.farhi.gametracker.backend.player.Player;
import com.farhi.gametracker.backend.player.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class GameMessageService {

    private final GameMessageRepository gameMessageRepository;
    private final PlayerRepository playerRepository;

    @Autowired
    public GameMessageService(GameMessageRepository gameMessageRepository, PlayerRepository playerRepository) {
        this.gameMessageRepository = gameMessageRepository;
        this.playerRepository = playerRepository;
    }

    public List<GameMessageResponse> getMessagesReceivedForUser(Long id) {
        Optional<Player> playerOptional = playerRepository.findById(id);
        if (playerOptional.isPresent()) {
            Optional<List<GameMessage>> gameMessage = gameMessageRepository
                    .findAllByReceivingPlayer(playerOptional.get());
            return convertGameMessagesToResponseObjects(gameMessage.get());
        }
        return new ArrayList<>();
    }

    public List<GameMessageResponse> getMessagesSentForUser(Long id) {
        Optional<Player> playerOptional = playerRepository.findById(id);
        if (playerOptional.isPresent()) {
            Optional<List<GameMessage>> gameMessage = gameMessageRepository
                    .findAllBySendingPlayer(playerOptional.get());
            return convertGameMessagesToResponseObjects(gameMessage.get());
        }
        return new ArrayList<>();
    }

    private List<GameMessageResponse> convertGameMessagesToResponseObjects(List<GameMessage> messages) {
        List<GameMessageResponse> response = new ArrayList<>();
        messages.forEach(gameMessage -> {
            response.add(
                    new GameMessageResponse(
                            gameMessage.getId(),
                            gameMessage.getSendingPlayer().getId(),
                            gameMessage.getReceivingPlayer().getId(),
                            gameMessage.getSendingPlayer().getPlayerName(),
                            gameMessage.getReceivingPlayer().getPlayerName(),
                            gameMessage.getSendingPlayerScore(),
                            gameMessage.getReceivingPlayerScore()
                    )
            );
        });
        return response;
    }

    public Map<String, String> deleteMessage(Long id) {
        Optional<GameMessage> optionalGameMessage = gameMessageRepository.findById(id);
        if (optionalGameMessage.isPresent()) {
            gameMessageRepository.deleteById(optionalGameMessage.get().getId());
            return Map.of("status", "successfully deleted");
        }
        return Map.of("status", "game message id not found");
    }
}
