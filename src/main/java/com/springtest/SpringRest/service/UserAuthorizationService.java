package com.springtest.SpringRest.service;

import com.springtest.SpringRest.model.Credentials;

import java.util.Optional;

public interface UserAuthorizationService {
    boolean registerUser(Credentials userCredentials);
    Optional<String> authorizeUser(Credentials userCredentials);
    boolean removeUser(String apiKey);
}
