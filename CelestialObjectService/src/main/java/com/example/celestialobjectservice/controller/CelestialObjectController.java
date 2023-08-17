package com.example.celestialobjectservice.controller;


import com.example.celestialobjectservice.dto.CelestialObjectRequestDto;
import com.example.celestialobjectservice.entity.CelestialObject;
import com.example.celestialobjectservice.service.CelestialObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/celestial_object")
public class CelestialObjectController {
    @Autowired
    private CelestialObjectService celestialObjectService;

    @PostMapping("/create")
    public ResponseEntity<CelestialObject> create (@RequestBody CelestialObjectRequestDto celestialObjectRequestDto ){
        return ResponseEntity.ok(celestialObjectService.create(celestialObjectRequestDto));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<CelestialObject> update (@RequestBody CelestialObjectRequestDto celestialObjectRequestDto,@PathVariable int id){
        return ResponseEntity.ok(celestialObjectService.update(celestialObjectRequestDto,id));
    }
}
