package com.example.ewaserver.models;

import java.util.List;

public class Lobby {
    private long LobbyId;
    private int playerNumber;
    private String LobbyCode;
    private int BotAmount;
    private List<Lobby> LobbyList;

    public Lobby(long lobbyId, int playerNumber, String lobbyCode, int botAmount, List<Lobby> lobbyList) {
        LobbyId = lobbyId;
        this.playerNumber = playerNumber;
        LobbyCode = lobbyCode;
        BotAmount = botAmount;
        LobbyList = lobbyList;
    }

    public long getLobbyId() {
        return LobbyId;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public String getLobbyCode() {
        return LobbyCode;
    }

    public int getBotAmount() {
        return BotAmount;
    }

    public List<Lobby> getLobbyList() {
        return LobbyList;
    }

    public void setLobbyId(long lobbyId) {
        LobbyId = lobbyId;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public void setLobbyCode(String lobbyCode) {
        LobbyCode = lobbyCode;
    }

    public void setBotAmount(int botAmount) {
        BotAmount = botAmount;
    }

    public void setLobbyList(List<Lobby> lobbyList) {
        LobbyList = lobbyList;
    }
}