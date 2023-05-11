package com.example.ewaserver.rest;


import com.example.ewaserver.exceptions.PreConditionFailed;
import com.example.ewaserver.exceptions.ResourceNotFoundException;
import com.example.ewaserver.models.Lobby;
import com.example.ewaserver.models.User;
import com.example.ewaserver.repositories.LobbyRepository;
import com.example.ewaserver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/Lobby")
public class LobbyController {

    @Autowired
    private LobbyRepository lobbyRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "", produces = "application/json")
    public List<Lobby> getAllLobbys() {
        return lobbyRepository.findAll();
    }

    @GetMapping(path = "/{join_code}", produces = "application/json")
    public List<Lobby> getLobbyByCode(@PathVariable String join_code) {
        return lobbyRepository.findByQuery("Lobby_find_by_code", join_code);
    }

    @GetMapping(path = "/lobby/{LobbyId}", produces = "application/json")
    public Set<User> getUsersConnectedToLobby(@PathVariable int LobbyId) {
        Lobby lobby = lobbyRepository.findById(LobbyId);
        Set<User> users = null;
        users = lobby.getUsers();
        return users;
    }

    @PostMapping(path = "/{userid}/{LobbyId}", produces = "application/json")
    public Lobby CombineLobbyWithUser(
            @PathVariable int userid,
            @PathVariable int LobbyId) {
        Set<User> usersInLobby = null;
        User user = userRepository.findById(userid);
        Lobby lobby = lobbyRepository.findById(LobbyId);
        usersInLobby = lobby.getUsers();
        usersInLobby.add(user);
        lobby.setUsers(usersInLobby);
        lobby.setPlayer_size(lobby.getPlayer_size() + 1);
        return lobbyRepository.Save(lobby);
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
    public ResponseEntity<Lobby> updateLobby(@RequestBody Lobby lobby, @PathVariable int id) {
        Lobby saveLobby = lobbyRepository.findById(id);
        if (saveLobby.getIdLobby() != id) {
            throw new PreConditionFailed("Id is not equal.");
        }

        saveLobby.setLobby_status(lobby.getLobby_status());
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

    @GetMapping(path = "/get/{id}", produces = "application/json")
    public User getUserById(@PathVariable int id) {

        User user = userRepository.findById(id);
        if (user == null) {
            throw new ResourceNotFoundException("user not found with id: " + id);
        }
        return user;
    }
}