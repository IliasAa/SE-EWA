package com.example.ewaserver.rest;

import com.example.ewaserver.models.Chat;
import com.example.ewaserver.models.User;
import com.example.ewaserver.notifications.NotificationDistributor;
import com.example.ewaserver.repositories.ChatRepository;
import com.example.ewaserver.repositories.UserRepository;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatRepository Repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NotificationDistributor notificationDistributor;

    @PostMapping(path = "", produces = "application/json")
    public String sendMessage(@RequestBody ObjectNode chatInfo) {
        Chat chat = new Chat(LocalDateTime.now(), chatInfo.get("message").asText());
        User user = this.userRepository.findById(chatInfo.get("id").asInt());
        chat.addUser(user);
        this.Repository.Save(chat);
        this.notificationDistributor.notify("chat");
        return "Message is successfully send!";
    }

    @GetMapping(path = "/getAll", produces = "application/json")
    public List<Chat> getAllMessages() {
        return this.Repository.findAll();
    }
}
