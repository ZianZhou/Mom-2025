package com.zian.jaroflove.controller;

import com.zian.jaroflove.model.Message;
import com.zian.jaroflove.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    private final MessageService service;

    public HomeController(MessageService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home() {
        return "index"; // show random message
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("message", new Message());
        return "add"; // renders add.html
    }

    @PostMapping("/add")
    public String submitForm(@ModelAttribute Message message) {
        service.addMessage(message.getText());
        return "redirect:/"; // go back to home
    }
}
