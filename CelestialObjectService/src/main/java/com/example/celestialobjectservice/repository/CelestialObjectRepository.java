package com.example.celestialobjectservice.repository;

import com.example.celestialobjectservice.entity.CelestialObject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CelestialObjectRepository extends CrudRepository<CelestialObject,Integer> {
    Optional<CelestialObject> findByName (String name);
}
