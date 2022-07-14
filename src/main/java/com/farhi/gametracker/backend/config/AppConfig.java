package com.farhi.gametracker.backend.config;

import com.farhi.gametracker.backend.gamemessage.GameMessage;
import com.farhi.gametracker.backend.gamemessage.GameMessageRepository;
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
    CommandLineRunner commandLineRunner(
            OfficeGameRepository gameRepository,
            PlayerRepository playerRepository,
            GameMessageRepository gameMessageRepository
    ) {
        return args -> {
            var player1 = new Player("Bob");
            var player2 = new Player("Jim");
            var player3 = new Player("Joe");
            playerRepository.saveAll(List.of(player1, player2, player3));

            var game1 = new OfficeGame(player1, player2, 21, 12);
            var game2 = new OfficeGame(player1, player2, 14, 21);
            var game3 = new OfficeGame(player1, player2, 21, 8);
            var game4 = new OfficeGame(player3, player2, 21, 12);
            var game5 = new OfficeGame(player2, player1, 18, 21);
            gameRepository.saveAll(List.of(game1, game2, game3, game4, game5));

            var message1 = new GameMessage(player2, player1, 20, 21);
            var message2 = new GameMessage(player3, player1, 18, 21);
            var message3 = new GameMessage(player1, player2, 21, 5);
            gameMessageRepository.saveAll(List.of(message1, message2, message3));
        };
    }
}
