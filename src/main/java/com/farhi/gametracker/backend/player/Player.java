package com.farhi.gametracker.backend.player;

import com.farhi.gametracker.backend.officegame.OfficeGame;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "player")
public class Player {
    @Id
    @SequenceGenerator(
            name = "player_sequence",
            sequenceName = "player_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy=GenerationType.SEQUENCE,
            generator = "player_sequence"
    )
    @Column(name = "id")
    private Long id;
    private String playerName;

    @OneToMany(mappedBy="playerOne")
    private Set<OfficeGame> gamesWherePlayerOne;
    @OneToMany(mappedBy="playerTwo")
    private Set<OfficeGame> gamesWherePlayerTwo;

    public Player() {}

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public Set<OfficeGame> getGamesWherePlayerOne() {
        return gamesWherePlayerOne;
    }

    public void setGamesWherePlayerOne(Set<OfficeGame> gamesWherePlayerOne) {
        this.gamesWherePlayerOne = gamesWherePlayerOne;
    }

    public Set<OfficeGame> getGamesWherePlayerTwo() {
        return gamesWherePlayerTwo;
    }

    public void setGamesWherePlayerTwo(Set<OfficeGame> gamesWherePlayerTwo) {
        this.gamesWherePlayerTwo = gamesWherePlayerTwo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
