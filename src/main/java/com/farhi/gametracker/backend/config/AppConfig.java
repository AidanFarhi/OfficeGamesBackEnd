package com.farhi.gametracker.backend.config;

import com.farhi.gametracker.backend.officegame.OfficeGame;
import com.farhi.gametracker.backend.officegame.OfficeGameRepository;
import com.farhi.gametracker.backend.player.Player;
import com.farhi.gametracker.backend.player.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    CommandLineRunner commandLineRunner(OfficeGameRepository gameRepository, PlayerRepository playerRepository) {
        return args -> {
            var player1 = new Player("Bob");
            var player2 = new Player("Jim");
            playerRepository.saveAll(List.of(player1, player2));

            var game1 = new OfficeGame(player1, player2, 21, 12);
            var game2 = new OfficeGame(player1, player2, 14, 21);
            var game3 = new OfficeGame(player1, player2, 21, 8);
            gameRepository.saveAll(List.of(game1, game2, game3));
        };
    }
}
