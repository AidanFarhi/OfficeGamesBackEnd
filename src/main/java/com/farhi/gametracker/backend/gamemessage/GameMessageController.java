package com.farhi.gametracker.backend.gamemessage;

import com.farhi.gametracker.backend.json.GameMessageResponse;
import com.farhi.gametracker.backend.json.GameMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/get-messages-sent")
    public List<GameMessageResponse> getMessagesSentForUser(@RequestParam Long id) {
        return service.getMessagesSentForUser(id);
    }

    @PostMapping("/send-game-message")
    public Map<String, String> sendGameMessage(@RequestBody GameMessageRequest request) {
        return service.sendGameMessage(request);
    }

    @DeleteMapping("/delete-message")
    public Map<String, String> deleteMessage(@RequestParam Long id) {
        return service.deleteMessage(id);
    }
}
