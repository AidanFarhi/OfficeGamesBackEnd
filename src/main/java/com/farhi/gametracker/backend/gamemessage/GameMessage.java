package com.farhi.gametracker.backend.gamemessage;

import com.farhi.gametracker.backend.player.Player;

import javax.persistence.*;

@Entity
@Table(name = "game_message")
public class GameMessage {
    @Id
    @SequenceGenerator(
            name = "game_message_sequence",
            sequenceName = "game_message_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy=GenerationType.SEQUENCE,
            generator = "game_message_sequence"
    )
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sending_player_id")
    Player sendingPlayer;

    @ManyToOne
    @JoinColumn(name = "receiving_player_id")
    Player receivingPlayer;

    public GameMessage(){}

    public GameMessage(Player sendingPlayer, Player receivingPlayer) {
        this.sendingPlayer = sendingPlayer;
        this.receivingPlayer = receivingPlayer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getSendingPlayer() {
        return sendingPlayer;
    }

    public void setSendingPlayer(Player sendingPlayer) {
        this.sendingPlayer = sendingPlayer;
    }

    public Player getReceivingPlayer() {
        return receivingPlayer;
    }

    public void setReceivingPlayer(Player receivingPlayer) {
        this.receivingPlayer = receivingPlayer;
    }
}
