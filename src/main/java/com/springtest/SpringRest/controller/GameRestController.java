package com.springtest.SpringRest.controller;

import com.springtest.SpringRest.model.Room;
import com.springtest.SpringRest.repository.RoomRepository;
import com.springtest.SpringRest.repository.UserRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class GameRestController {

    private RoomRepository roomRepository;
    private UserRepository repository;

    public GameRestController(RoomRepository roomRepository, UserRepository repository) {
        this.roomRepository = roomRepository;
        this.repository = repository;
    }

    // Manage

    // Getters

    @RequestMapping(method = RequestMethod.GET, value = "/game/{gameId}")
    Optional<Room> getGame(@PathVariable Long gameId) {
        return this.roomRepository.findById(gameId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/games")
    Collection<Room> getAllGames() {
        return this.roomRepository.findAll();
    }
}
