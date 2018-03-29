package com.springtest.SpringRest.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

//    private GameRepository gameRepository;
//    private UserRepository userRepository;
//
//    public DevBootstrap(GameRepository gameRepository, UserRepository userRepository) {
//        this.gameRepository = gameRepository;
//        this.userRepository = userRepository;
//    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
//        this.initData();
    }

    private void initData() {

//        User john = new User("John", "Doe");
//        User bob = new User("Bob", "Marley");
//
////        this.userRepository.save(john);
////        this.userRepository.save(bob);
//
//        Room game = new Room("firstGame");
////        this.gameRepository.save(game);
//
////        game.addUser(john);
//        john.setRoom(game);
//        bob.setRoom(game);
    }
}
