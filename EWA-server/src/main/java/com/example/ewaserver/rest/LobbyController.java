package com.example.ewaserver.rest;


import com.example.ewaserver.models.Lobby;
import com.example.ewaserver.repositories.LobbyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Lobby")
public class LobbyController {

    @Autowired
    private LobbyRepository lobbyRepository;

    @GetMapping("")
    public List<Lobby> getAllLobbys(){
        return lobbyRepository.findAll();
    }

    @PostMapping("/onlineGame")
    public ResponseEntity<Object> CreateNewLobby(@RequestBody Lobby lobby) {

        return null;
    }
}