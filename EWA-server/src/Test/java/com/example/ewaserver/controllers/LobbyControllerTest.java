package com.example.ewaserver.controllers;

import com.example.ewaserver.models.Lobby;
import com.example.ewaserver.models.User;
import com.example.ewaserver.models.UserHasLobby;
import com.example.ewaserver.notifications.NotificationDistributor;
import com.example.ewaserver.repositories.LobbyRepository;
import com.example.ewaserver.repositories.UserHasLobbyRepository;
import com.example.ewaserver.repositories.UserRepository;
import com.example.ewaserver.rest.LobbyController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.swing.UIManager.put;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@WebMvcTest(controllers = LobbyController.class)
public class LobbyControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private LobbyRepository lobbyRepository;
    @MockBean
    private UserHasLobbyRepository userLobbyRepository;
    @MockBean
    private UserRepository userRepository;

    @Test
    public void testGetAllLobbys() throws Exception {
        List<Lobby> lobbys = new ArrayList<>();

        when(lobbyRepository.findAll()).thenReturn(lobbys);

        mvc.perform(get("/Lobby"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON))
                .andExpect((ResultMatcher) jsonPath("$").isArray())
                .andReturn();

        verify(lobbyRepository).findAll();
    }

    @Test
    public void testGetLobbyByCode() throws Exception {
        String joinCode = "abc123";
        List<Lobby> lobbies = new ArrayList<>();
        // Voeg gewenste Lobby-objecten toe aan de lobbies-lijst

        when(lobbyRepository.findByQuery("Lobby_find_by_code", joinCode)).thenReturn(lobbies);

        mvc.perform(get("/Lobby/{joinCode}", joinCode))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON))
                .andExpect((ResultMatcher) jsonPath("$").isArray());

        verify(lobbyRepository).findByQuery("Lobby_find_by_code", joinCode);
    }

    @Test
    public void testCombineLobbyWithUser() throws Exception {
        int userId = 1;
        int lobbyId = 2;
        String selectedColor = "red";

        User user = new User(4,"jan12","jan","12","jan@hva.nl","jan123",12,"player"); // Maak een dummy User-object
        Lobby lobby = new Lobby("jan122",0,3,4,0,3); // Maak een dummy Lobby-object

        when(userRepository.findById(userId)).thenReturn(user);
        when(lobbyRepository.findById(lobbyId)).thenReturn(lobby);
        when(userLobbyRepository.Save(any(UserHasLobby.class))).thenReturn(new UserHasLobby());

        mvc.perform(post("/Lobby/{userid}/{LobbyId}/{selectedcolor}", userId, lobbyId, selectedColor))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON));

        verify(userRepository).findById(userId);
        verify(lobbyRepository).findById(lobbyId);
        verify(userLobbyRepository).Save(any(UserHasLobby.class));
    }



//    @Test
//    public void testCreateNewLobby() throws Exception {
//        Lobby lobby = new Lobby("niu322",1,2,1,1,2); // Maak een dummy Lobby-object
//
//        when(lobbyRepository.Save(any(Lobby.class))).thenReturn(lobby);
//
//        mvc.perform(post("/Lobby")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{ \"propertyName\": \"propertyValue\" }")) // Voeg hier de juiste JSON-invoer toe voor de lobby
//                .andExpect(status().isCreated())
//                .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON));
//
//        verify(lobbyRepository).Save(any(Lobby.class));
//    }

    @Test
    public void testUpdatePlayerCount() throws Exception {
        int lobbyId = 1;

        Lobby lobby = new Lobby("njh344",0,2,1,2,1); // Maak een dummy Lobby-object

        when(lobbyRepository.findById(lobbyId)).thenReturn(lobby);
        when(lobbyRepository.Save(any(Lobby.class))).thenReturn(lobby);

        mvc.perform((RequestBuilder) put("/Lobby/player/{id}", lobbyId))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON));

        verify(lobbyRepository).findById(lobbyId);
        verify(lobbyRepository).Save(any(Lobby.class));
    }

    @Test
    public void testDeleteLobby() throws Exception {
        int lobbyId = 1;
        Lobby lobby = new Lobby("njh344", 0, 2, 1, 2, 1); // Maak een dummy Lobby-object

        when(lobbyRepository.deleteById(lobbyId)).thenReturn(lobby);

        mvc.perform(delete("/Lobby/{id}", lobbyId))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON));

        verify(lobbyRepository).deleteById(lobbyId);
    }

    @Test
    public void testGetUserById() throws Exception {
        int userId = 1;
        User user = new User(userId, "john", "john","Doe","johnDoe@hva.nl","test123",12,"player"); // Maak een dummy User-object

        when(userRepository.findById(userId)).thenReturn(user);

        mvc.perform(get("/Lobby/get/{id}", userId))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON))
                .andExpect((ResultMatcher) jsonPath("$.id").value(userId));

        verify(userRepository).findById(userId);
    }

    @Test
    public void testCheckPlayerCount() throws Exception {
        int lobbyId = 1;
        Lobby lobby = new Lobby("njh344", 0, 2, 1, 2, 1); // Maak een dummy Lobby-object

        when(lobbyRepository.findById(lobbyId)).thenReturn(lobby);

        mvc.perform(get("/Lobby/checkPlayers/{id}", lobbyId))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().string("2")); // Verwacht aantal spelers in de lobby

        verify(lobbyRepository).findById(lobbyId);
    }

    
}
