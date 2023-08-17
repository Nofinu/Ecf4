package com.example.celestialobjectservice.controller;

import com.example.celestialobjectservice.entity.CelestialObject;
import com.example.celestialobjectservice.service.CelestialObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/celestial_object")
public class CelestialObjectFinderController {
    @Autowired
    private CelestialObjectService celestialObjectService;

    @GetMapping("")
    public ResponseEntity<List<CelestialObject>> findAll(){
        return ResponseEntity.ok(celestialObjectService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CelestialObject> findById (@PathVariable int id){
        return ResponseEntity.ok(celestialObjectService.findById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<CelestialObject> findByName (@PathVariable String name){
        return ResponseEntity.ok(celestialObjectService.findByName(name));
    }
}
