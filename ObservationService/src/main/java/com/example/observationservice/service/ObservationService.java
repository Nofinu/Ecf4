package com.example.observationservice.service;

import com.example.observationservice.dto.ObservationRequestDto;
import com.example.observationservice.dto.ObservationResponseDto;
import com.example.observationservice.repository.ObservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObservationService {
    @Autowired
    private ObservationRepository observationRepository;

    private ObservationResponseDto create (ObservationRequestDto observationRequestDto){
        return null;
    }
}
