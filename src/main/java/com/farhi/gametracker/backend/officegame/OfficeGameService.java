package com.farhi.gametracker.backend.officegame;

import com.farhi.gametracker.backend.json.NewGameRequest;
import com.farhi.gametracker.backend.player.Player;
import com.farhi.gametracker.backend.player.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<OfficeGame> getOfficeGames() {
        return officeGameRepository.findAll();
    }

    public void addNewGame(NewGameRequest request) {
        Optional<Player> playerOneOptional = playerRepository.findById(request.getPlayerOneId());
        Optional<Player> playerTwoOptional = playerRepository.findById(request.getPlayerTwoId());
        Integer playerOneScore = request.getPlayerOneScore();
        Integer playerTwoScore = request.getPlayerTwoScore();
        if (playerOneOptional.isPresent() && playerTwoOptional.isPresent()) {
            Player playerOne = playerOneOptional.get();
            Player playerTwo = playerTwoOptional.get();
            OfficeGame newGame = new OfficeGame(playerOne, playerTwo, playerOneScore, playerTwoScore);
            officeGameRepository.save(newGame);
        }
    }
}
