package com.farhi.gametracker.backend.officegame;

import com.farhi.gametracker.backend.json.NewGameRequest;
import com.farhi.gametracker.backend.json.OfficeGameResponse;
import com.farhi.gametracker.backend.player.Player;
import com.farhi.gametracker.backend.player.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OfficeGameService {

    private final OfficeGameRepository officeGameRepository;
    private final PlayerRepository playerRepository;

    @Autowired
    public OfficeGameService(OfficeGameRepository officeGameRepository, PlayerRepository playerRepository) {
        this.officeGameRepository = officeGameRepository;
        this.playerRepository = playerRepository;
    }

    public void addNewGame(NewGameRequest request) {
        Optional<Player> playerOneOptional = playerRepository.findById(request.getPlayerOneId());
        Optional<Player> playerTwoOptional = playerRepository.findByPlayerName(request.getPlayerTwoName());
        Integer playerOneScore = request.getPlayerOneScore();
        Integer playerTwoScore = request.getPlayerTwoScore();
        if (playerOneOptional.isPresent() && playerTwoOptional.isPresent()) {
            Player playerOne = playerOneOptional.get();
            Player playerTwo = playerTwoOptional.get();
            OfficeGame newGame = new OfficeGame(playerOne, playerTwo, playerOneScore, playerTwoScore);
            officeGameRepository.save(newGame);
        }
    }

    public List<OfficeGameResponse> getUserGames(Long id) {
        List<OfficeGameResponse> response = new ArrayList<>();
        Optional<Player> playerOptional = playerRepository.findById(id);
        if (playerOptional.isPresent()) {
            Player player = playerOptional.get();
            for (OfficeGame game : player.getGamesWherePlayerOne()) {
                String playerOneName = player.getPlayerName();
                String playerTwoName = game.getPlayerTwo().getPlayerName();
                response.add(new OfficeGameResponse(
                        game.getId(), playerOneName, playerTwoName,
                        game.getPlayerOneScore(), game.getPlayerTwoScore())
                );
            }
            for (OfficeGame game : player.getGamesWherePlayerTwo()) {
                String playerOneName = game.getPlayerOne().getPlayerName();
                String playerTwoName = player.getPlayerName();
                response.add(new OfficeGameResponse(
                        game.getId(), playerOneName, playerTwoName,
                        game.getPlayerOneScore(), game.getPlayerTwoScore())
                );
            }
        }
        return response;
    }

    public void deleteGame(Long id) {
        Optional<OfficeGame> officeGameOptional = officeGameRepository.findById(id);
        officeGameOptional.ifPresent(officeGameRepository::delete);
    }
}
