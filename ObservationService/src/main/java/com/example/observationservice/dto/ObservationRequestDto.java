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
public class ObservationRequestDto {
    private String date;
    private String description;
    private boolean publics;
    private int celestialObjectId;
    private int userAppId;
}
