package com.farhi.gametracker.backend.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/player")
public class PlayerController {

    private PlayerService service;

    @Autowired
    public PlayerController(PlayerService service) {
        this.service = service;
    }

    public List<Player> getPlayers() {
        return service.getPlayers();
    }
}
