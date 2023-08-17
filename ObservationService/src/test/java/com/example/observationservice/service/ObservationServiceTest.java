package com.example.observationservice.service;

import com.example.observationservice.Exception.NotFoundException;
import com.example.observationservice.dto.CelestialObject;
import com.example.observationservice.dto.ObservationRequestDto;
import com.example.observationservice.dto.ObservationResponseDto;
import com.example.observationservice.entity.Observation;
import com.example.observationservice.repository.ObservationRepository;
import com.example.observationservice.tools.RestClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ObservationServiceTest {

    @InjectMocks
    private ObservationService observationService;

    @Mock
    private ObservationRepository observationRepository;

    @Test
    void testCreateExpectObservation (){
        ObservationRequestDto observationRequestDto = ObservationRequestDto.builder()
                .publics(true)
                .userAppId(1)
                .celestialObjectId(1)
                .date("2018-12-27")
                .description("description")
                .build();

        Observation observation = Observation.builder()
                .publics(true)
                .userAppId(1)
                .celestialObjectId(1)
                .date(LocalDate.parse("2018-12-27"))
                .description("description")
                .build();

        Observation observationCreated =Observation.builder()
                .id(1)
                .publics(true)
                .userAppId(1)
                .celestialObjectId(1)
                .date(LocalDate.parse("2018-12-27"))
                .description("description")
                .build();

        Mockito.when(observationRepository.save(observation)).thenReturn(observationCreated);
        Assertions.assertEquals(observationCreated,observationService.create(observationRequestDto));
    }

    @Test
    void testUpdateWithIdInDataBaseExpectObservation (){
        ObservationRequestDto observationRequestDto = ObservationRequestDto.builder()
                .publics(true)
                .userAppId(1)
                .celestialObjectId(1)
                .date("2018-12-27")
                .description("description2")
                .build();

        Observation observationfind = Observation.builder()
                .id(1)
                .publics(true)
                .userAppId(1)
                .celestialObjectId(1)
                .date(LocalDate.parse("2018-12-27"))
                .description("description")
                .build();
        Optional<Observation> observationOptional = Optional.of(observationfind);

        Observation observationupdate = Observation.builder()
                .id(1)
                .publics(true)
                .userAppId(1)
                .celestialObjectId(1)
                .date(LocalDate.parse("2018-12-27"))
                .description("description2")
                .build();

        Mockito.when(observationRepository.findById(1)).thenReturn(observationOptional);
        Mockito.when(observationRepository.save(observationupdate)).thenReturn(observationupdate);
        Assertions.assertEquals(observationupdate,observationService.update(observationRequestDto,1));
    }

    @Test
    void testUpdateWithIdNotInDataBaseExpectNotFoundException (){
        ObservationRequestDto observationRequestDto = ObservationRequestDto.builder()
                .publics(true)
                .userAppId(1)
                .celestialObjectId(1)
                .date("2018-12-27")
                .description("description2")
                .build();
        Optional<Observation> observation = Optional.empty();
        Mockito.when(observationRepository.findById(1)).thenReturn(observation);

        Assertions.assertThrows(NotFoundException.class,()->observationService.update(observationRequestDto,1));
    }

    @Test
    void testFindByCelestialObjectIdExpectObservation (){
        Observation observation = Observation.builder()
                .id(1)
                .celestialObjectId(1)
                .description("description2")
                .build();
        List<Observation> observations = new ArrayList<>();
        observations.add(observation);
        Mockito.when(observationRepository.findByCelestialObjectId(1)).thenReturn(observations);

        Assertions.assertEquals(observations,observationService.findByCelestialObject(1));
    }

    @Test
    void testFindByUserAppIdIdExpectObservation (){
        Observation observation = Observation.builder()
                .id(1)
                .userAppId(1)
                .description("description2")
                .build();
        List<Observation> observations = new ArrayList<>();
        observations.add(observation);
        Mockito.when(observationRepository.findByUserAppId(1)).thenReturn(observations);

        Assertions.assertEquals(observations,observationService.findByUserApp(1));
    }

    @Test
    void testFindByDateIdExpectObservation (){
        LocalDate date = LocalDate.parse("2018-12-27");
        Observation observation = Observation.builder()
                .id(1)
                .date(date)
                .description("description2")
                .build();
        List<Observation> observations = new ArrayList<>();
        observations.add(observation);

        Mockito.when(observationRepository.findByDate(date)).thenReturn(observations);

        Assertions.assertEquals(observations,observationService.findByDate(date));
    }


    @Test
    void testFindByIdWhenIdInDataBaseExpectObservation (){
        Observation observationfind = Observation.builder()
                .id(1)
                .description("description")
                .build();
        Optional<Observation> observationOptional = Optional.of(observationfind);

        Mockito.when(observationRepository.findById(1)).thenReturn(observationOptional);
        Assertions.assertEquals(observationfind,observationService.findById(1));

    }

    @Test
    void testFindByIdWhenIdNotInDataBaseExpectNotFoundException (){

        Optional<Observation> observationOptional = Optional.empty();

        Mockito.when(observationRepository.findById(1)).thenReturn(observationOptional);
        Assertions.assertThrows(NotFoundException.class,()->observationService.findById(1));
    }


    @Test
    void testFindallExpectListOfObservation (){

        Observation observation = Observation.builder()
                .id(1)
                .description("description2")
                .build();
        List<Observation> observations = new ArrayList<>();
        observations.add(observation);


        Mockito.when(observationRepository.findAll()).thenReturn(observations);
        Assertions.assertEquals(observations,observationService.findAll());
    }
}
