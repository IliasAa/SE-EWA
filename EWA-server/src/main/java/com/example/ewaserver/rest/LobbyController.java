package com.example.ewaserver.rest;


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

    @GetMapping("")
    public List<Lobby> getAllLobbys(){
        return lobbyRepository.findAll();
    }

    @GetMapping("/{id}")
    public Lobby getLobbyByCode(@PathVariable int id){
        Lobby lobbyCode = lobbyRepository.findById(id);
        if (lobbyCode == null) {
            throw new ResourceNotFoundException("lobby not found with id: " + id);
        }
        return lobbyCode;
    }

    @PostMapping("/onlineGame")
    public ResponseEntity<Object> CreateNewLobby(@RequestBody Lobby lobby) {

        Lobby saveLobby = lobbyRepository.Save(lobby);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(saveLobby.getLobbyId()).toUri();
        return ResponseEntity.created(location).body(saveLobby);
    }

    @DeleteMapping(path = "/{id}")
    public Lobby deleteOwnUser(@PathVariable() int id) {

        Lobby lobby = this.lobbyRepository.deleteById(id);
        if (lobby == null) {
            throw new ResourceNotFoundException("Cannot delete an lobby with id=" + id);
        }
        return lobby;
    }
}