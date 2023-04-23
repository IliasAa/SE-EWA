package com.example.ewaserver.rest;


import com.example.ewaserver.models.Lobby;
import com.example.ewaserver.repositories.LobbyRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Lobby")
public class LobbyController {

    private LobbyRepository lobbyRepository;

    public long getAllLobbys(int id){
        return this.lobbyRepository.findById(id).getLobbyId();
    }


    record LobbyRequest(String LobbyCode, long LobbiId) { }
    record LobbyResponse(String LobbyCode) {
    }
    record AiBot(int amount){

    }

    @GetMapping("/Lobby/join")
    public LobbyController.LobbyRequest Join(Lobby lobby) {

        return new LobbyRequest(lobby.getLobbyCode(), lobby.getLobbyId());
    }

//    @PostMapping(value = "/Lobby/Offline")
//    public LobbyController.AiBot BotAmount(Lobby lobby, int amount) {
//
//        return new AiBot(lobby.setBotAmount(amount));
//    }
//
//    @PostMapping("/Lobby/Online")
//    public LobbyController.LobbyResponse Start(Lobby lobby,String lobbyCode) {
//
//        return new LobbyResponse(lobby.setLobbyCode(lobbyCode));
//    }
}