package com.springtest.SpringRest;

import com.springtest.SpringRest.model.Room;
import com.springtest.SpringRest.model.User;
import com.springtest.SpringRest.repository.RoomRepository;
import com.springtest.SpringRest.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
public class UserEntityManager implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(UserEntityManager.class);

    private RoomRepository roomRepository;
    private UserRepository userRepository;

    public UserEntityManager(RoomRepository roomRepository, UserRepository userRepository) {
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {

        roomRepository.deleteAllInBatch();
        userRepository.deleteAllInBatch();
//
////        Room room = new Room("firstGame");
////
////        User harry = new User("Harry", "1234");
////        harry.setRoom(room);
//
//        room.getUsers().add(harry);
//
//        this.gameRepository.save(room);
//
//        log.info("-------------------------------");
//        log.info("Finding all users");
//        log.info("-------------------------------");
////        for (User user : this.userRepository.findAll()) {
////            log.info(user.toString());
//        }

        Room room = new Room();

//        User john = new User("John");
//        User bob = new User("Bob");
//        User steve = new User("Steve");
//        john.setRoom(room);
//        bob.setRoom(room);

//        this.roomRepository.save(room);
//        this.userRepository.save(john);
//        this.userRepository.save(bob);
//        this.userRepository.save(steve);
    }

}