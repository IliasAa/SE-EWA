import com.example.ewaserver.models.Chat;
import com.example.ewaserver.models.User;
import com.example.ewaserver.notifications.NotificationDistributor;
import com.example.ewaserver.repositories.ChatRepository;
import com.example.ewaserver.repositories.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ChatControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ChatRepository chatRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private NotificationDistributor notificationDistributor;

    @InjectMocks
    private ChatController chatController;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(chatController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testGetAllMessages() throws Exception {
        List<Chat> chatList = new ArrayList<>();
        // Add some test chat messages to the list
        chatList.add(new Chat(LocalDateTime.now(), "Message 1"));
        chatList.add(new Chat(LocalDateTime.now(), "Message 2"));

        when(chatRepository.findAll()).thenReturn(chatList);

        mockMvc.perform(MockMvcRequestBuilders.get("/chat/getAll")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(chatList.size()));
    }

    @Test
    public void testSendMessage() throws Exception {
        // Mock the necessary dependencies
        User fromUser = new User();
        User toUser = new User();
        ObjectNode chatInfo = JsonNodeFactory.instance.objectNode();
        chatInfo.put("message", "Hello, friend!");
        chatInfo.put("id", 1);

        when(userRepository.findById(any())).thenReturn(fromUser, toUser);
        when(chatRepository.save(any(Chat.class))).thenReturn(new Chat());

        mockMvc.perform(MockMvcRequestBuilders.post("/chat/friend/{id}", 1)
                        .content(objectMapper.writeValueAsString(chatInfo))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Message is successfully send!"));
    }

    @Test
    public void testGetMessageForFriend() throws Exception {
        long id1 = 1;
        long id2 = 2;
        List<Chat> chatList = new ArrayList<>();
        // Add some test chat messages to the list
        chatList.add(new Chat(LocalDateTime.now(), "Message 1"));
        chatList.add(new Chat(LocalDateTime.now(), "Message 2"));

        when(chatRepository.chatsWithFriend(id1, id2)).thenReturn(chatList);

        mockMvc.perform(MockMvcRequestBuilders.get("/chat/{id}&{id2}", id1, id2)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(chatList.size()));
    }

    @Test
    public void testGetSearchedUsers() throws Exception {
        String keyword = "john";
        List<User> userList = new ArrayList<>();
        // Add some test users to the list
        userList.add(new User());
        userList.add(new User());

        when(chatRepository.searchUsersByUsername(keyword)).thenReturn(userList);

        mockMvc.perform(MockMvcRequestBuilders.get("/chat/searchUser/{keyword}", keyword)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(userList.size()));
    }

    @Test
    public void testAddFriend() throws Exception {
        ObjectNode userAndFriend = JsonNodeFactory.instance.objectNode();
        userAndFriend.put("userId", 1);
        userAndFriend.put("friendId", 2);

        User user = new User();
        User friend = new User();

        when(userRepository.findById(any())).thenReturn(user, friend);
        when(userRepository.save(any(User.class))).thenReturn(user);

        mockMvc.perform(MockMvcRequestBuilders.post("/chat/addFriend")
                        .content(objectMapper.writeValueAsString(userAndFriend))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("true"));
    }
}
