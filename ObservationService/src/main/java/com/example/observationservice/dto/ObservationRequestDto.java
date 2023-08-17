package com.example.observationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObservationRequestDto {
    private int id;
    private LocalDate date;
    private String description;
    private int celestialObjectId;
}
