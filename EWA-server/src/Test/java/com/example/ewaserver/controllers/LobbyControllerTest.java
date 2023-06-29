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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.swing.UIManager.put;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@WebMvcTest(controllers = LobbyController.class)
public class LobbyControllerTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private LobbyController lobbyController;

    @MockBean
    private LobbyRepository lobbyRepository;
    @MockBean
    private UserHasLobbyRepository userLobbyRepository;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private NotificationDistributor notificationDistributor;

    private ObjectMapper objectMapper;

    private Lobby lobby1;

    private Lobby lobby2;

    private List<Lobby> lobbys;

    public void setup() {
        mvc = MockMvcBuilders.standaloneSetup(lobbyController).build();
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

    @Test
    public void testCreateNewLobby() throws Exception {
        Lobby lobby = new Lobby("niu322",1,2,1,1,2); // Maak een dummy Lobby-object

        when(lobbyRepository.Save(any(Lobby.class))).thenReturn(lobby);

        mvc.perform(post("/Lobby")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"propertyName\": \"propertyValue\" }")) // Voeg hier de juiste JSON-invoer toe voor de lobby
                .andExpect(status().isCreated())
                .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON));

        verify(lobbyRepository).Save(any(Lobby.class));
    }

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
//
//    @BeforeEach()
//    public void setup() {
//        objectMapper = new ObjectMapper();
//
//        lobby1 = new Lobby("abc123",0,3,4,1,3);
//        lobby2 = new Lobby("def456",1,2,2,0,2);;
//
//        lobbys = new ArrayList<>(List.of(lobby1, lobby2));
//    }
//
//    @Test
//    public void getLobbysByJoincode() throws Exception {
//        mvc.perform(get("/Lobby/abc123"))
//                .andExpect(status().isOk());
//
//        verify(lobbyRepository).findByQuery("Find_all_lobby's_connected_with_player", "abc123");
//    }
//

}
