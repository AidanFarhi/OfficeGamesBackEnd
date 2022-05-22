package com.farhi.gametracker.backend.player;

import com.farhi.gametracker.backend.json.PlayerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    private PlayerRepository repository;

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
}
