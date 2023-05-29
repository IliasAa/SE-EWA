package com.example.ewaserver.rest;

import com.example.ewaserver.Config;
import com.example.ewaserver.models.Lobby;
import com.example.ewaserver.models.Playerposition;
import com.example.ewaserver.repositories.LudoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/ludo")
public class LudoController {

    @Autowired
    Config apiconfig;

    @Autowired
    private LudoRepository repository;

    @GetMapping(path = "", produces = "application/json")
    public List<Playerposition> getAllPlayermoves() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public List<Playerposition> getPlayermovesOnLobbyid(@PathVariable int id) {
        return repository.findByQuery("Find_Playermoves_based_of_lobbyId", id);
    }
}
