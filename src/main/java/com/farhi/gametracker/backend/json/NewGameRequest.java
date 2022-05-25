package com.farhi.gametracker.backend.json;

public class NewGameRequest {

    private Long playerOneId;
    private String playerTwoName;
    private Integer playerOneScore;
    private Integer playerTwoScore;

    public NewGameRequest() {}

    public NewGameRequest(Long playerOneId, String playerTwoName, Integer playerOneScore, Integer playerTwoScore) {
        this.playerOneId = playerOneId;
        this.playerTwoName = playerTwoName;
        this.playerOneScore = playerOneScore;
        this.playerTwoScore = playerTwoScore;
    }

    public Long getPlayerOneId() {
        return playerOneId;
    }

    public void setPlayerOneId(Long playerOneId) {
        this.playerOneId = playerOneId;
    }

    public String getPlayerTwoName() {
        return playerTwoName;
    }

    public void setPlayerTwoName(String playerTwoName) {
        this.playerTwoName = playerTwoName;
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
