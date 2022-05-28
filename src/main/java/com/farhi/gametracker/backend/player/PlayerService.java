package com.farhi.gametracker.backend.player;

import com.farhi.gametracker.backend.json.PlayerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository repository;

    @Autowired
    public PlayerService(PlayerRepository repository) {
        this.repository = repository;
    }

    public List<PlayerResponse> getPlayers() {
        List<PlayerResponse> response = new ArrayList<>();
        List<Player> players = repository.findAll();
        for (Player player : players) {
            response.add(new PlayerResponse(player.getId(), player.getPlayerName()));
        }
        return response;
    }

    public void addNewPlayer(Player newPlayer) {
        // TODO: check if player already exists
        repository.save(newPlayer);
    }

    public void deletePlayer(Long id) {
        Optional<Player> playerOptional = repository.findById(id);
        playerOptional.ifPresent(repository::delete);
    }

    public Long login(String username) {
        Optional<Player> playerOptional = repository.findByPlayerName(username);
        if (playerOptional.isPresent()) {
            return playerOptional.get().getId();
        }
        return -1L;
    }
}
