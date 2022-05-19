package com.farhi.gametracker.backend.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private PlayerRepository repository;

    @Autowired
    public PlayerService(PlayerRepository repository) {
        this.repository = repository;
    }

    public List<Player> getPlayers() {
        return repository.findAll();
    }
}
