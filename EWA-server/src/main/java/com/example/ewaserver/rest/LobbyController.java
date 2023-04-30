package com.example.ewaserver.rest;


import com.example.ewaserver.exceptions.PreConditionFailed;
import com.example.ewaserver.exceptions.ResourceNotFoundException;
import com.example.ewaserver.models.Lobby;
import com.example.ewaserver.models.User;
import com.example.ewaserver.repositories.LobbyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/Lobby")
public class LobbyController {

    @Autowired
    private LobbyRepository lobbyRepository;

    @GetMapping(path = "", produces = "application/json")
    public List<Lobby> getAllLobbys(){
        return lobbyRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Lobby getLobbyByCode(@PathVariable int id){
        Lobby lobbyCode = lobbyRepository.findById(id);
        if (lobbyCode == null) {
            throw new ResourceNotFoundException("lobby not found with id: " + id);
        }
        return lobbyCode;
    }

    @PostMapping(path = "/onlineGame", produces = "application/json")
    public ResponseEntity<Object> CreateNewLobby(@RequestBody Lobby lobby) {

        Lobby saveLobby = lobbyRepository.Save(lobby);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(saveLobby.getLobbyId()).toUri();
        return ResponseEntity.created(location).body(saveLobby);
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<Lobby> updateUser(@RequestBody Lobby lobby,@PathVariable int id) {
        Lobby saveLobby = lobbyRepository.findById(id);
        if (saveLobby.getLobbyId() != id) {
            throw new PreConditionFailed("Id is not equal.");
        }


        saveLobby.setLobbyCode(lobby.getLobbyCode());
        saveLobby.setCollorList(lobby.getCollorList());
        saveLobby.setPlayerList(lobby.getPlayerList());

        lobbyRepository.Save(saveLobby);
        return ResponseEntity.ok().body(saveLobby);
    }


    @DeleteMapping(path = "/delete", produces = "application/json")
    public Lobby deleteOwnUser(@PathVariable() int id) {

        Lobby lobby = this.lobbyRepository.deleteById(id);
        if (lobby == null) {
            throw new ResourceNotFoundException("Cannot delete an lobby with id=" + id);
        }
        return lobby;
    }
}