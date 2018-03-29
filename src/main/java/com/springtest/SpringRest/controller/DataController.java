package com.springtest.SpringRest.controller;

import com.springtest.SpringRest.repository.RoomRepository;
import com.springtest.SpringRest.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DataController {

    private RoomRepository roomRepository;
    private UserRepository userRepository;

    public DataController(RoomRepository roomRepository, UserRepository userRepository) {
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
    }

    @RequestMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", this.userRepository.findAll());
        return "users";
    }

    @RequestMapping("/games")
    public String getAllGames(Model model) {
        model.addAttribute("games", this.roomRepository.findAll());
        return "games";
    }
}
