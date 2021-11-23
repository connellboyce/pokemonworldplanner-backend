package com.connell.pokemonworldplanner.repository;

import com.connell.pokemonworldplanner.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * Interface to allow querying users based on the backend Mongo database.
 */
public interface UserRepository extends MongoRepository<User, String> {
    /**
     * Searches for a user in the DB and returns if found.
     *
     * @param username username to search for
     * @return User object if found, otherwise nothing.
     */
    Optional<User> findByUsername(String username);

    /**
     * Searches for a user in the DB and says if the username was found.
     *
     * @param username username to search for
     * @return if username is in use already
     */
    boolean existsByUsername(String username);

    /**
     * Searches for a user in the DB and says if the email was found.
     *
     * @param email email address to search for
     * @return if email is in use already
     */
    boolean existsByEmail(String email);
}
