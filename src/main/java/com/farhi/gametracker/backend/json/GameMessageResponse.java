package com.farhi.gametracker.backend.json;

public class GameMessageResponse {

    private Long gameMessageId;
    private Long sendingPlayerId;
    private String sendingPlayerName;
    private Long receivingPlayerId;
    private String receivingPlayerName;
    private Integer sendingPlayerScore;
    private Integer receivingPlayerScore;

    public GameMessageResponse(Long gameMessageId, Long sendingPlayerId, Long receivingPlayerId, String sendingPlayerName, String receivingPlayerName,
                               Integer sendingPlayerScore, Integer receivingPlayerScore) {
        this.gameMessageId = gameMessageId;
        this.sendingPlayerName = sendingPlayerName;
        this.receivingPlayerName = receivingPlayerName;
        this.sendingPlayerScore = sendingPlayerScore;
        this.receivingPlayerScore = receivingPlayerScore;
        this.sendingPlayerId = sendingPlayerId;
        this.receivingPlayerId = receivingPlayerId;
    }

    public Long getSendingPlayerId() {
        return sendingPlayerId;
    }

    public void setSendingPlayerId(Long sendingPlayerId) {
        this.sendingPlayerId = sendingPlayerId;
    }

    public Long getReceivingPlayerId() {
        return receivingPlayerId;
    }

    public void setReceivingPlayerId(Long receivingPlayerId) {
        this.receivingPlayerId = receivingPlayerId;
    }

    public Integer getSendingPlayerScore() {
        return sendingPlayerScore;
    }

    public void setSendingPlayerScore(Integer sendingPlayerScore) {
        this.sendingPlayerScore = sendingPlayerScore;
    }

    public Integer getReceivingPlayerScore() {
        return receivingPlayerScore;
    }

    public void setReceivingPlayerScore(Integer receivingPlayerScore) {
        this.receivingPlayerScore = receivingPlayerScore;
    }

    public String getSendingPlayerName() {
        return sendingPlayerName;
    }

    public void setSendingPlayerName(String sendingPlayerName) {
        this.sendingPlayerName = sendingPlayerName;
    }

    public String getReceivingPlayerName() {
        return receivingPlayerName;
    }

    public void setReceivingPlayerName(String receivingPlayerName) {
        this.receivingPlayerName = receivingPlayerName;
    }

    public Long getGameMessageId() {
        return gameMessageId;
    }

    public void setGameMessageId(Long gameMessageId) {
        this.gameMessageId = gameMessageId;
    }
}
