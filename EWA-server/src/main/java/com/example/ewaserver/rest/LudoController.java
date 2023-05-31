package com.example.ewaserver.rest;

import com.example.ewaserver.Config;
import com.example.ewaserver.exceptions.PreConditionFailed;
import com.example.ewaserver.models.Lobby;
import com.example.ewaserver.models.Playerposition;
import com.example.ewaserver.repositories.LobbyRepository;
import com.example.ewaserver.repositories.LudoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/Ludo")
public class LudoController {

    @Autowired
    Config apiconfig;

    @Autowired
    private LudoRepository repository;

    @Autowired
    private LobbyRepository lobbyRepository;

    @GetMapping(path = "", produces = "application/json")
    public List<Playerposition> getAllPlayermoves() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public List<Playerposition> getPlayermovesOnLobbyid(@PathVariable int id) {
        return repository.findByQuery("Find_Playermoves_based_of_lobbyId", id);
    }

    @PostMapping(path = "/save/{lobbyId}", produces = "application/json")
    public ResponseEntity<Object> CreateNewPlayermove(@PathVariable int lobbyId,
            @RequestBody Playerposition pPos) {
        Lobby lobby = lobbyRepository.findById(lobbyId);
        pPos.setLobby(lobby);



        Playerposition savePmove = repository.Save(pPos);

        URI location = ServletUriComponentsBuilder.
                fromCurrentRequest()
                .path("/{id}").
                buildAndExpand(savePmove.getIdPlayerposition()).toUri();

        return ResponseEntity.created(location).body(savePmove);

    }

    @PutMapping(path = "")
    public ResponseEntity<Lobby> updateLobby(@RequestBody Playerposition playerposition, @PathVariable int id) {
        return null;
    }

}
