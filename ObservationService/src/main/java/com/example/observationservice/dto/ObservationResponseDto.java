package com.example.observationservice.dto;

import java.time.LocalDate;

public class ObservationResponseDto {
    private int id;
    private LocalDate date;
    private String description;
    private CelestialObject celestialObject;
}
