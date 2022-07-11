package com.farhi.gametracker.backend.json;

public class GameMessageResponse {

    private Long sendingPlayerId;
    private Long receivingPlayerId;

    public GameMessageResponse() {}

    public GameMessageResponse(Long sendingPlayerId, Long receivingPlayerId) {
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
}
