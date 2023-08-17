package com.example.observationservice.repository;

import com.example.observationservice.entity.Observation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ObservationRepository extends CrudRepository<Observation,Integer> {
    @Query("SELECT o from Observation as o where o.celestialObjectId = ?1 and o.publics = TRUE ")
    List<Observation> findByCelestialObjectId (int id);
    @Query("SELECT o from Observation as o where o.userAppId = ?1 and o.publics = TRUE ")
    List<Observation> findByUserAppId (int id);
    @Query("SELECT o from Observation as o where o.date = ?1 and o.publics = TRUE ")
    List<Observation> findByDate(LocalDate date);
}
