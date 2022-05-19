package com.farhi.gametracker.backend.json;

public class NewGameRequest {

    private Long playerOneId;
    private Long playerTwoId;
    private Integer playerOneScore;
    private Integer playerTwoScore;

    public NewGameRequest() {}

    public NewGameRequest(Long playerOneId, Long playerTwoId, Integer playerOneScore, Integer playerTwoScore) {
        this.playerOneId = playerOneId;
        this.playerTwoId = playerTwoId;
        this.playerOneScore = playerOneScore;
        this.playerTwoScore = playerTwoScore;
    }

    public Long getPlayerOneId() {
        return playerOneId;
    }

    public void setPlayerOneId(Long playerOneId) {
        this.playerOneId = playerOneId;
    }

    public Long getPlayerTwoId() {
        return playerTwoId;
    }

    public void setPlayerTwoId(Long playerTwoId) {
        this.playerTwoId = playerTwoId;
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
