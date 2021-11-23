package com.connell.pokemonworldplanner.controller;

import com.connell.pokemonworldplanner.payload.request.RegisterRequest;
import com.connell.pokemonworldplanner.payload.request.SignInRequest;
import com.connell.pokemonworldplanner.repository.UserRepository;
import com.connell.pokemonworldplanner.service.authn.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/authn")
public class AuthnController {
    private Logger logger = LoggerFactory.getLogger(AuthnController.class);

    @Autowired
    AuthService authService;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@Valid @RequestBody SignInRequest request) {
        logger.info("User \"{}\" is attempting to sign in...", request.getUsername());
        return authService.authenticateUser(request);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest request) {
        logger.info("Attempting to create account for user \"{}\"", request.getUsername());
        logger.info("User details: firstName={}, lastName={}, email={}", request.getFirstName(), request.getLastName(), request.getEmail());
        return authService.registerUser(request);
    }
}
