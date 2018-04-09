package com.springtest.SpringRest.service;

import com.springtest.SpringRest.model.Credentials;
import com.springtest.SpringRest.model.User;
import com.springtest.SpringRest.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAuthorizationServiceImpl implements UserAuthorizationService {

    private BCryptPasswordEncoder passwordEncoder;

    private UserRepository userRepository;

    public UserAuthorizationServiceImpl(BCryptPasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public boolean registerUser(Credentials userCredentials) {
        if (!this.userRepository.findByUsername(userCredentials.getUsername()).isPresent()) {
            this.userRepository.save(new User(userCredentials.getUsername(), userCredentials.getPassword()).setApiKey(this.getApiKey(userCredentials.getPassword())));
            return true;
        }
        return false;
    }

    @Override
    public Optional<String> authorizeUser(Credentials userCredentials) {
        final Optional<User> user = this.userRepository.findByUsername(userCredentials.getUsername());
        if (user.isPresent()) {
            System.out.println("USER AUTH " + user.toString());
        }
        if (user.isPresent() && user.get().getPassword().equals(userCredentials.getPassword()))
            return Optional.of(user.get().getApiKey());
        return Optional.of("asdas");
    }

    @Override
    public boolean removeUser(String apiKey) {
        return false;
    }

    private String getApiKey(String password) {
        return this.passwordEncoder.encode(password);
    }
}
