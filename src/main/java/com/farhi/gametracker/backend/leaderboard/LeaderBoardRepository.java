package com.farhi.gametracker.backend.leaderboard;

import com.farhi.gametracker.backend.officegame.OfficeGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaderBoardRepository extends JpaRepository<OfficeGame, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM leaderboard;")
    List<LeaderBoardRow> getLeaderboard();
}
