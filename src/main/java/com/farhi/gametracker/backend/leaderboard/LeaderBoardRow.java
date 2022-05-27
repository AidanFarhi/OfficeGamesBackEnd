package com.farhi.gametracker.backend.leaderboard;


import org.springframework.beans.factory.annotation.Value;

public interface LeaderBoardRow {
    @Value("#{target.player_name}")
    String getPlayerName();
    @Value("#{target.games_played}")
    Integer getGamesPlayed();
    @Value("#{target.points_for}")
    Integer getPointsFor();
    @Value("#{target.points_against}")
    Integer getPointsAgainst();
    @Value("#{target.wins}")
    Integer getWins();
    @Value("#{target.losses}")
    Integer getLosses();
    @Value("#{target.win_percentage}")
    Double getWinPercentage();
}
