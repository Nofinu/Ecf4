package com.example.observationservice.service;

import com.example.observationservice.dto.CelestialObject;
import com.example.observationservice.dto.ObservationResponseDto;
import com.example.observationservice.entity.Observation;
import com.example.observationservice.tools.RestClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObservationConverterService {
    public ObservationResponseDto convert (Observation observation){
        RestClient<CelestialObject> celestialObjectRestClient =new RestClient<>();

        return ObservationResponseDto.builder()
                .id(observation.getId())
                .description(observation.getDescription())
                .date(observation.getDate())
                .publics(observation.isPublics())
                .celestialObject(celestialObjectRestClient.get("celestial_object/"+observation.getCelestialObjectId(),CelestialObject.class))
                .userAppId(observation.getUserAppId()).build();
    }

    public List<ObservationResponseDto> convertList (List<Observation> observations){
        RestClient<CelestialObject> celestialObjectRestClient =new RestClient<>();
        List<ObservationResponseDto> observationResponseDtos =new ArrayList<>();

        observations.forEach(o ->{
            observationResponseDtos.add(ObservationResponseDto.builder()
                    .id(o.getId())
                    .description(o.getDescription())
                    .date(o.getDate())
                    .publics(o.isPublics())
                    .celestialObject(celestialObjectRestClient.get("celestial_object/"+o.getCelestialObjectId(),CelestialObject.class))
                    .userAppId(o.getUserAppId()).build());
        });

        return observationResponseDtos;
    }
}
