package com.example.observationservice.controller;

import com.example.observationservice.dto.ObservationRequestDto;
import com.example.observationservice.dto.ObservationResponseDto;
import com.example.observationservice.entity.Observation;
import com.example.observationservice.service.ObservationConverterService;
import com.example.observationservice.service.ObservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/observation")
public class ObservationController {
    @Autowired
    private ObservationService observationService;
    @Autowired
    private ObservationConverterService observationConverterService;

    @PostMapping("/create")
    public ResponseEntity<ObservationResponseDto> create (@RequestBody ObservationRequestDto observationRequestDto){
        Observation observation = observationService.create(observationRequestDto);
        return ResponseEntity.ok(observationConverterService.convert(observation));
    }

    @PostMapping("update/{id}")
    public ResponseEntity<ObservationResponseDto> update (@RequestBody ObservationRequestDto observationRequestDto, @PathVariable int id){
        Observation observation = observationService.update(observationRequestDto,id);
        return ResponseEntity.ok(observationConverterService.convert(observation));
    }
}
