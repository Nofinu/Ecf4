package com.example.observationservice.service;

import com.example.observationservice.Exception.NotFoundException;
import com.example.observationservice.dto.CelestialObject;
import com.example.observationservice.dto.ObservationRequestDto;
import com.example.observationservice.dto.ObservationResponseDto;
import com.example.observationservice.entity.Observation;
import com.example.observationservice.repository.ObservationRepository;
import com.example.observationservice.tools.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ObservationService {
    @Autowired
    private ObservationRepository observationRepository;

    public Observation create (ObservationRequestDto observationRequestDto){

        return observationRepository.save(Observation.builder()
                .description(observationRequestDto.getDescription())
                .date(LocalDate.parse(observationRequestDto.getDate()))
                .publics(observationRequestDto.isPublics())
                .celestialObjectId(observationRequestDto.getCelestialObjectId())
                .userAppId(observationRequestDto.getUserAppId())
                .build());
    }

    public Observation update (ObservationRequestDto observationRequestDto,int id){
        Optional<Observation> observationOptional = observationRepository.findById(id);
        if(observationOptional.isPresent()){
            Observation observationFind = observationOptional.get();
            observationFind.setDescription(observationRequestDto.getDescription());
            observationFind.setPublics(observationRequestDto.isPublics());
            observationFind.setDate(LocalDate.parse(observationRequestDto.getDate()));
            observationFind.setUserAppId(observationRequestDto.getUserAppId());
            observationFind.setCelestialObjectId(observationRequestDto.getCelestialObjectId());

            return observationRepository.save(observationFind);
        }
        throw new NotFoundException();
    }

    public List<Observation> findByCelestialObject (int celestialObjectId){
        return observationRepository.findByCelestialObjectId(celestialObjectId);
    }

    public List<Observation> findByUserApp (int userAppId){
        return observationRepository.findByUserAppId(userAppId);
    }

    public List<Observation> findByDate (LocalDate date){
        return observationRepository.findByDate(date);
    }

    public Observation findById(int id){
        Optional<Observation> observationOptional =  observationRepository.findById(id);
        if(observationOptional.isPresent()){
            return observationOptional.get();
        }
        throw new NotFoundException();
    }
    public List<Observation> findAll(){
        return (List<Observation>) observationRepository.findAll();
    }

}
