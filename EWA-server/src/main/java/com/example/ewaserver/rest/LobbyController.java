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

    @GetMapping(path = "/{join_code}", produces = "application/json")
    public Lobby getLobbyByCode(@PathVariable String join_code){
        Lobby lobby = lobbyRepository.findByLobbyCode(join_code);
        if (lobby == null) {
            throw new ResourceNotFoundException("lobby not found with join_code:" + join_code);
        }
        return lobby;
    }

    @PostMapping(path = "", produces = "application/json")
    public ResponseEntity<Object> CreateNewLobby(@RequestBody Lobby lobby) {

        Lobby saveLobby = lobbyRepository.Save(lobby);

        URI location = ServletUriComponentsBuilder.
                fromCurrentRequest()
                .path("/{id}").
                buildAndExpand(saveLobby.getIdLobby()).toUri();

        return ResponseEntity.created(location).body(saveLobby);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Lobby> updateLobby(@RequestBody Lobby lobby,@PathVariable int id) {
        Lobby saveLobby = lobbyRepository.findById(id);
        if (saveLobby.getIdLobby() != id) {
            throw new PreConditionFailed("Id is not equal.");
        }


        saveLobby.setJoin_code(lobby.getJoin_code());

        lobbyRepository.Save(saveLobby);
        return ResponseEntity.ok().body(saveLobby);
    }


    @DeleteMapping(path = "/{id}")
    public Lobby deletelobby(@PathVariable() int id) {

        Lobby lobby = this.lobbyRepository.deleteById(id);
        if (lobby == null) {
            throw new ResourceNotFoundException("Cannot delete an lobby with id=" + id);
        }
        return lobby;
    }
}