package com.example.observationservice.controller;

import com.example.observationservice.dto.ObservationResponseDto;
import com.example.observationservice.entity.Observation;
import com.example.observationservice.service.ObservationConverterService;
import com.example.observationservice.service.ObservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/observation")
public class ObservationFinderController {
    @Autowired
    private ObservationService observationService;
    @Autowired
    private ObservationConverterService observationConverterService;

    @GetMapping("")
    public ResponseEntity<List<ObservationResponseDto>> findAll (){
        List<Observation> observations = observationService.findAll();
        return ResponseEntity.ok(observationConverterService.convertList(observations));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObservationResponseDto> findById (@PathVariable int id){
        Observation observation = observationService.findById(id);
        return ResponseEntity.ok(observationConverterService.convert(observation));
    }

    @GetMapping("/celestial_object/{id}")
    public ResponseEntity<List<ObservationResponseDto>> findByCelestialObject (@PathVariable int id){
        List<Observation> observations =observationService.findByCelestialObject(id);
        return ResponseEntity.ok(observationConverterService.convertList(observations));
    }

    @GetMapping("/userapp/{id}")
    public ResponseEntity<List<ObservationResponseDto>> findByUserApp (@PathVariable int id){
        List<Observation> observations =observationService.findByUserApp(id);
        return ResponseEntity.ok(observationConverterService.convertList(observations));
    }


    //dateformat yyyy-MM-dd
    @GetMapping("/date/{date}")
    public ResponseEntity<List<ObservationResponseDto>> findByDate (@PathVariable String date){
        try{
            List<Observation> observations =observationService.findByDate(LocalDate.parse(date));
            return ResponseEntity.ok(observationConverterService.convertList(observations));
        }catch (Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
