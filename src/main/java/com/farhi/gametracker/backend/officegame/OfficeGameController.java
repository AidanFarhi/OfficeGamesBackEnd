package com.farhi.gametracker.backend.officegame;

import com.farhi.gametracker.backend.json.NewGameRequest;
import com.farhi.gametracker.backend.json.OfficeGameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/office-games")
public class OfficeGameController {

    private OfficeGameService service;

    @Autowired
    public OfficeGameController(OfficeGameService service) {
        this.service = service;
    }

    @GetMapping("/user-games")
    public List<OfficeGameResponse> getUserGames(@RequestParam Long id) {
        return service.getUserGames(id);
    }

    @PostMapping("/new-game")
    public void newGame(@RequestBody NewGameRequest request) {
        service.addNewGame(request);
    }
}
