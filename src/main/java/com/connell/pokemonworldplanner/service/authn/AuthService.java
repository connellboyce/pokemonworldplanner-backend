package com.connell.pokemonworldplanner.service.authn;

import com.connell.pokemonworldplanner.payload.request.RegisterRequest;
import com.connell.pokemonworldplanner.payload.request.SignInRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.Map;

public interface AuthService {
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody SignInRequest signInRequest);

    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest registerRequest);

    public Map<String, String> handleValidationException(MethodArgumentNotValidException exception);
}
