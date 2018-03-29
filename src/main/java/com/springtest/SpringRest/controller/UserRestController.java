package com.springtest.SpringRest.controller;

import com.springtest.SpringRest.exception.RoomNotFoundException;
import com.springtest.SpringRest.exception.UserAlreadyExistsException;
import com.springtest.SpringRest.exception.UserNotFoundException;
import com.springtest.SpringRest.model.Room;
import com.springtest.SpringRest.model.User;
import com.springtest.SpringRest.repository.UserRepository;
import com.springtest.SpringRest.repository.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.websocket.server.PathParam;
import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/users")
public class UserRestController {

    final static Logger logger = LoggerFactory.getLogger(UserRestController.class);

    private RoomRepository roomRepository;
	private UserRepository userRepository;

    public UserRestController(RoomRepository roomRepository, UserRepository userRepository) {
        this.roomRepository = roomRepository;
		this.userRepository = userRepository;
	}

	// Manage user

    // ...create
    @RequestMapping(value = "/{username}", method = RequestMethod.POST)
    ResponseEntity<?> registerUser(@PathVariable String username) {
        this.validateUserNotExists(username);
        this.userRepository.save(new User(username));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return ResponseEntity.created(location).body(username + " created!");
    }

    // ...remove
    @RequestMapping(value = "/{username}", method = RequestMethod.DELETE)
    ResponseEntity<String> removeUser(@PathVariable String username) {
        final User userToRemove = this.validateUserExists(username);
        this.userRepository.delete(userToRemove);
        return ResponseEntity.ok(username + " removed!");
    }

    // ...get by ID
    @RequestMapping(value = "/id/{userId}", method = RequestMethod.GET)
    Optional<User> getUserById(@PathVariable Long userId) {
        this.validateUserExists(userId);
        return this.userRepository.findById(userId);
    }

    // ...get by username
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    Optional<User> getUserByUsername(@PathVariable String username) {
        this.validateUserExists(username);
        return this.userRepository.findByUsername(username);
    }

    // ...get all
    @RequestMapping(method = RequestMethod.GET)
    Collection<User> getAllUsers(@PathParam("keyword") String keyword) {
        final List<User> allUsersList = this.userRepository.findAll();
        if (keyword != null)
    	    return allUsersList.stream().filter(user -> user.getUsername().contains(keyword)).collect(Collectors.toList());
        return allUsersList;
    }

    // Manage user room

    // ...join room
    @RequestMapping(value = "/{userId}/room/{roomId}", method = RequestMethod.POST)
    ResponseEntity<String> userJoinRoom(@PathVariable Long userId, @PathVariable Long roomId) {
        User user = this.validateUserExists(userId);
        Room room = this.validateRoomExists(roomId);
        if (!user.hasRoom()) {
            user.setRoom(room);
            this.userRepository.flush();
            return ResponseEntity.ok(user.getUsername() + " joined to room with ID: " + room.getId());
        }
        return new ResponseEntity<>(user.getUsername() + " already is room!", HttpStatus.CONFLICT);
    }

    // ...leave room
    @RequestMapping(value = "/{userId}/room", method = RequestMethod.DELETE)
    ResponseEntity<String> userLeaveRoom(@PathVariable Long userId) {
        User user = this.validateUserExists(userId);
        if (user.hasRoom()) {
            user.removeRoom();
            this.userRepository.flush();
            return ResponseEntity.ok(user.getUsername() + " left the game");
        }
        return new ResponseEntity<>(user.getUsername() + " already outside any room!", HttpStatus.CONFLICT);
    }

    // ...get room by ID
    @RequestMapping(value = "/{userId}/room", method = RequestMethod.GET)
    Optional<User> getUserRoomById(@PathVariable Long userId) {
        this.validateUserExists(userId);
        return this.userRepository.findById(userId);
    }

    private User validateUserExists(String username) {
        return this.userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
    }
    
    private User validateUserExists(Long userId) {
		return this.userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
	}

	private Room validateRoomExists(Long roomId) {
        return this.roomRepository.findById(roomId).orElseThrow(() -> new RoomNotFoundException(roomId));
    }

	private void validateUserNotExists(String username) {
        this.userRepository.findByUsername(username).ifPresent(user -> {throw new UserAlreadyExistsException(username);});
    }

}
