package com.farhi.gametracker.backend.leaderboard;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/leaderboard")
public class LeaderBoardController {

    private LeaderBoardService service;

    public LeaderBoardController(LeaderBoardService service) {
        this.service = service;
    }

    @GetMapping("/latest")
    public List<LeaderBoardRow> getLatestLeaderboard() {
        return service.getLeaderboard();
    }
}
