package com.farhi.gametracker.backend.leaderboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaderBoardService {

    private final LeaderBoardRepository repository;

    @Autowired
    public LeaderBoardService(LeaderBoardRepository repository) {
        this.repository = repository;
    }

    public List<LeaderBoardRow> getLeaderboard() {
        return repository.getLeaderboard();
    }
}
