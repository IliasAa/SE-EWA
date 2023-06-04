package com.example.ewaserver.rest;

import com.example.ewaserver.Config;
import com.example.ewaserver.exceptions.PreConditionFailed;
import com.example.ewaserver.models.Lobby;
import com.example.ewaserver.models.Playerposition;
import com.example.ewaserver.models.Turn;
import com.example.ewaserver.repositories.LobbyRepository;
import com.example.ewaserver.repositories.TurnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/Dice")
public class diceController {

    @Autowired
    Config apiconfig;

    @Autowired
    private TurnRepository repository;
    @Autowired
    private LobbyRepository lobbyRepository;

    @GetMapping(path = "", produces = "application/json")
    public List<Turn> getAllPlayermoves() {
        return repository.findAll();
    }


    @GetMapping(path = "/{lobbyId}", produces = "application/json")
    public List<Turn> getPlayermovesOnLobbyid(@PathVariable int lobbyId) {
        Lobby lobby = lobbyRepository.findById(lobbyId);
        if (lobby == null) {
            throw new PreConditionFailed("Need a valid lobby");
        }

        return repository.findByQuery("Find_Turns_based_of_lobbyId", lobby);
    }


}