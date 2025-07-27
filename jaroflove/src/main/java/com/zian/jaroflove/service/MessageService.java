package com.zian.jaroflove.service;

import com.zian.jaroflove.model.Message;
import com.zian.jaroflove.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class MessageService {

    private final MessageRepository repo;
    private final Random random = new Random();

    public MessageService(MessageRepository repo) {
        this.repo = repo;
    }

    public Message getRandomMessage() {
        List<Message> messages = repo.findAll();
        if (messages.isEmpty()) {
            return new Message("You are loved 💖");
        }
        return messages.get(random.nextInt(messages.size()));
    }

    public List<Message> getAllMessages() {
        return repo.findAll();
    }

    public Message addMessage(String text) {
        return repo.save(new Message(text));
    }
}
