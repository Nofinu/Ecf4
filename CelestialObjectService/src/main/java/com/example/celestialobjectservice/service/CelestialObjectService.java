package com.example.celestialobjectservice.service;

import com.example.celestialobjectservice.Exception.NotFoundException;
import com.example.celestialobjectservice.dto.CelestialObjectRequestDto;
import com.example.celestialobjectservice.entity.CelestialObject;
import com.example.celestialobjectservice.repository.CelestialObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CelestialObjectService {
    @Autowired
    private CelestialObjectRepository celestialObjectRepository;

    public void setCelestialObjectRepository(CelestialObjectRepository celestialObjectRepository) {
        this.celestialObjectRepository = celestialObjectRepository;
    }

    public CelestialObject create(CelestialObjectRequestDto celestialObjectRequestDto) {
        CelestialObject celestialObject = CelestialObject.builder().name(celestialObjectRequestDto.getName()).build();
        return celestialObjectRepository.save(celestialObject);
    }

    public CelestialObject update(CelestialObjectRequestDto celestialObjectRequestDto,int id){
        CelestialObject celestialObject = findById(id);
        celestialObject.setName(celestialObjectRequestDto.getName());
        return celestialObjectRepository.save(celestialObject);
    }

    public CelestialObject findById(int id) {
        Optional<CelestialObject> celestialObjectOptional = celestialObjectRepository.findById(id);
        if(celestialObjectOptional.isPresent()){
            return celestialObjectOptional.get();
        }
        throw new NotFoundException();
    }

    public CelestialObject findByName (String name){
        Optional<CelestialObject> celestialObjectOptional = celestialObjectRepository.findByName(name);
        if(celestialObjectOptional.isPresent()){
            return celestialObjectOptional.get();
        }
        throw new NotFoundException();
    }

    public List<CelestialObject> findAll (){
        return (List<CelestialObject>) celestialObjectRepository.findAll();
    }
}
