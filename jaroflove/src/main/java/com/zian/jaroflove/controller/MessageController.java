package com.zian.jaroflove.controller;

import com.zian.jaroflove.model.Message;
import com.zian.jaroflove.service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin(origins = "*")
public class MessageController {

    private final MessageService service;

    public MessageController(MessageService service) {
        this.service = service;
    }

    @GetMapping("/random")
    public Message getRandomMessage() {
        return service.getRandomMessage();
    }

    @PostMapping
    public Message addMessage(@RequestBody Message msg) {
        return service.addMessage(msg.getText());
    }

    @GetMapping
    public List<Message> getAllMessages() {
        return service.getAllMessages();
    }
}
