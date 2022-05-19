package com.farhi.gametracker.backend.officegame;

import com.farhi.gametracker.backend.json.NewGameRequest;
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

    @GetMapping("/get-games")
    public List<OfficeGame> allGames() {
        return service.getOfficeGames();
    }

    @PostMapping("/new-game")
    public void newGame(@RequestBody NewGameRequest request) {
        service.addNewGame(request);
    }
}
