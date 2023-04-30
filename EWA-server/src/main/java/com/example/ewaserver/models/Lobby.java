package com.example.ewaserver.models;

import java.util.List;

public class Lobby {
    private long LobbyId;
    private String LobbyCode;
    private List<Lobby> PlayerList;
    private List<Lobby> CollorList;

    public Lobby(long lobbyId, String lobbyCode, List<Lobby> playerList, List<Lobby> collorList) {
        LobbyId = lobbyId;
        LobbyCode = lobbyCode;
        PlayerList = playerList;
        CollorList = collorList;
    }

    public long getLobbyId() {
        return LobbyId;
    }

    public String getLobbyCode() {
        return LobbyCode;
    }

    public List<Lobby> getPlayerList() {
        return PlayerList;
    }

    public List<Lobby> getCollorList() {
        return CollorList;
    }

    public void setLobbyId(long lobbyId) {
        LobbyId = lobbyId;
    }

    public void setLobbyCode(String lobbyCode) {
        LobbyCode = lobbyCode;
    }

    public void setPlayerList(List<Lobby> playerList) {
        PlayerList = playerList;
    }

    public void setCollorList(List<Lobby> collorList) {
        CollorList = collorList;
    }
}