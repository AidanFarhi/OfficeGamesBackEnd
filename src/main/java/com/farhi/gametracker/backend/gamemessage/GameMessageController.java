package com.farhi.gametracker.backend.gamemessage;

import com.farhi.gametracker.backend.json.GameMessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/game-message")
public class GameMessageController {

    private GameMessageService service;

    @Autowired
    public GameMessageController(GameMessageService service) {
        this.service = service;
    }

    @GetMapping("/get-messages-received")
    public List<GameMessageResponse> getMessagesReceivedForUser(@RequestParam Long id) {
        return service.getMessagesReceivedForUser(id);
    }
}
