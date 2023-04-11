package com.example.ewaserver.models;

import java.lang.reflect.Array;
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

    public void setLobbyId(long lobbycode) {
        LobbyId = lobbycode;
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

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public String setLobbyCode(String lobbyCode) {
        LobbyCode = lobbyCode;
        return lobbyCode;
    }

    public int setBotAmount(int botAmount) {
        BotAmount = botAmount;
        return botAmount;
    }

    public void setLobbyList(List<Lobby> lobbyList) {
        LobbyList = lobbyList;
    }
}