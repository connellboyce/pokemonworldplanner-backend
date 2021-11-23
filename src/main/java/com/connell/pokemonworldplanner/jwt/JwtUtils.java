package com.connell.pokemonworldplanner.jwt;

import com.connell.pokemonworldplanner.service.authn.UserDetailsImpl;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {
    /**
     * This logger object gets the JwtUtils class logging capabilities
     */
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${pokemonworldplanner.app.jwtSecret}")
    private String jwtSecret;

    @Value("${pokemonworldplanner.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    /**
     * Creates the JWT
     *
     * @param authentication User's authentications
     * @throws IllegalArgumentException If the authentication hasn't been completed and "Authenticated" is false
     * @return built JWT
     */
    public String generateJwtToken(Authentication authentication) throws IllegalArgumentException {

        if (!authentication.isAuthenticated()) {
            throw new IllegalArgumentException("Authentication object provided is not completed -- auth required");
        }

        //Creates a User Detail object with our custom authentications
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        //Build JWT
        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    /**
     * Retrieves username from within the JWT
     *
     * @param token JWT to be parsed
     * @return String username
     */
    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    /**
     * Validates a JWT
     *
     * @param authToken uniquely generated authorization token
     * @return valid or invalid
     */
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }
}
