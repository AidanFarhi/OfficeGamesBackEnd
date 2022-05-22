package com.farhi.gametracker.backend.json;

public class PlayerResponse {

    private Long id;
    private String playerName;

    public PlayerResponse() {}

    public PlayerResponse(Long id, String playerName) {
        this.id = id;
        this.playerName = playerName;
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
