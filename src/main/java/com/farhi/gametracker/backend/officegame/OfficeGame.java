package com.farhi.gametracker.backend.officegame;

import com.farhi.gametracker.backend.player.Player;

import javax.persistence.*;

@Entity
@Table(name = "office_game")
public class OfficeGame {
    @Id
    @SequenceGenerator(
            name = "office_game_sequence",
            sequenceName = "office_game_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy=GenerationType.SEQUENCE,
            generator = "office_game_sequence"
    )
    @Column(name = "id")
    Long id;

    @ManyToOne
    @JoinColumn(name = "player_one_id")
    Player playerOne;

    @ManyToOne
    @JoinColumn(name = "player_two_id")
    Player playerTwo;
    Integer playerOneScore;
    Integer playerTwoScore;

    public OfficeGame() {}

    public OfficeGame(Player playerOne, Player playerTwo, Integer playerOneScore, Integer playerTwoScore) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.playerOneScore = playerOneScore;
        this.playerTwoScore = playerTwoScore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    public Integer getPlayerOneScore() {
        return playerOneScore;
    }

    public void setPlayerOneScore(Integer playerOneScore) {
        this.playerOneScore = playerOneScore;
    }

    public Integer getPlayerTwoScore() {
        return playerTwoScore;
    }

    public void setPlayerTwoScore(Integer playerTwoScore) {
        this.playerTwoScore = playerTwoScore;
    }
}
