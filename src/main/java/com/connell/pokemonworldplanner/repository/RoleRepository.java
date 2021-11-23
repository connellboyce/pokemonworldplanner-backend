package com.connell.pokemonworldplanner.repository;

import com.connell.pokemonworldplanner.model.ERole;
import com.connell.pokemonworldplanner.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
