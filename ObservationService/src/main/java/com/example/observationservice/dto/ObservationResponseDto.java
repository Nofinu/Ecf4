package com.example.observationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ObservationResponseDto {
    private int id;
    private LocalDate date;
    private String description;
    private boolean publics;
    private CelestialObject celestialObject;
    private int userAppId;
}
