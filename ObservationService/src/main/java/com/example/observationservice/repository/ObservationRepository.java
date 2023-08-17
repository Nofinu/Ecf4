package com.example.observationservice.repository;

import com.example.observationservice.entity.Observation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObservationRepository extends CrudRepository<Observation,Integer> {
}
