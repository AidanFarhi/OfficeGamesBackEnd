package com.farhi.gametracker.backend.player;

import com.farhi.gametracker.backend.json.PlayerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/player")
public class PlayerController {

    private final PlayerService service;

    @Autowired
    public PlayerController(PlayerService service) {
        this.service = service;
    }

    @GetMapping("/get-players")
    public List<PlayerResponse> getPlayers() {
        return service.getPlayers();
    }

    @PostMapping("/new-player")
    public void addNewPlayer(@RequestBody Player newPlayer) {
        service.addNewPlayer(newPlayer);
    }

    @PostMapping("/login")
    public Long login(@RequestBody HashMap<String, String> usernameRequest) {
        String username = usernameRequest.get("username");
        return service.login(username);
    }

    @DeleteMapping("/delete-player")
    public void deletePlayer(@RequestParam Long id) {
        service.deletePlayer(id);
    }
}
