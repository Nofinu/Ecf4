package com.example.celestialobjectservice.service;

import com.example.celestialobjectservice.Exception.NotFoundException;
import com.example.celestialobjectservice.dto.CelestialObjectRequestDto;
import com.example.celestialobjectservice.entity.CelestialObject;
import com.example.celestialobjectservice.repository.CelestialObjectRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CelestialObjectServiceTest {
    private CelestialObjectService celestialObjectService;

    @Mock
    private CelestialObjectRepository celestialObjectRepository;

    @BeforeEach
    void setUp(){
        celestialObjectService = new CelestialObjectService();
        celestialObjectService.setCelestialObjectRepository(celestialObjectRepository);
    }

    @Test
    void testCreateNewCelestialObjectExpectCelestialObject (){
        CelestialObjectRequestDto celestialObjectRequestDto = new CelestialObjectRequestDto("test");
        CelestialObject celestialObject = new CelestialObject(null,"test");
        Mockito.when(celestialObjectRepository.save(celestialObject)).thenReturn(new CelestialObject(1,"test"));
        Assertions.assertEquals(new CelestialObject(1,"test"),celestialObjectService.create(celestialObjectRequestDto));
    }

    @Test
    void testFindByIdWithIdInDataBaseExpectCelestialObject () {
        Optional<CelestialObject> celestialObjectOptional = Optional.of(new CelestialObject(1,"test"));
        Mockito.when(celestialObjectRepository.findById(1)).thenReturn(celestialObjectOptional);
        Assertions.assertEquals(new CelestialObject(1,"test"),celestialObjectService.findById(1));
    }

    @Test
    void testFindByIdWithIdNotInDataBaseExpectNotFoundException () {
        Optional<CelestialObject> celestialObjectOptional = Optional.empty();
        Mockito.when(celestialObjectRepository.findById(1)).thenReturn(celestialObjectOptional);
        Assertions.assertThrows(NotFoundException.class,()-> celestialObjectService.findById(1));
    }

    @Test
    void testUpdateWithIdInDataBaseExpectCelestialObjectUpdate () {
        Optional<CelestialObject> celestialObjectOptional = Optional.of(new CelestialObject(1,"test"));
        CelestialObjectRequestDto celestialObjectRequestDto = new CelestialObjectRequestDto("update");
        CelestialObject celestialObjectfind = new CelestialObject(1,"update");
        Mockito.when(celestialObjectRepository.findById(1)).thenReturn(celestialObjectOptional);
        Mockito.when(celestialObjectRepository.save(celestialObjectfind)).thenReturn(new CelestialObject(1,"update"));
        Assertions.assertEquals(new CelestialObject(1,"update"),celestialObjectService.update(celestialObjectRequestDto,1));
    }

    @Test
    void testUpdateWithIdNotInDataBaseExpectNotFoundException () {
        CelestialObjectRequestDto celestialObjectRequestDto = new CelestialObjectRequestDto("update");
        Mockito.when(celestialObjectRepository.findById(1)).thenThrow(NotFoundException.class);
        Assertions.assertThrows(NotFoundException.class,()->celestialObjectService.update(celestialObjectRequestDto,1));
    }

    @Test
    void testfindByNameWithNameInDataBaseExpectCelestialObjectUpdate () {
        Optional<CelestialObject> celestialObjectOptional = Optional.of(new CelestialObject(1,"test"));
        Mockito.when(celestialObjectRepository.findByName("test")).thenReturn(celestialObjectOptional);
        Assertions.assertEquals(new CelestialObject(1,"test"),celestialObjectService.findByName("test"));
    }

    @Test
    void testfindByNameWithNameNotInDataBaseExpectNotFoundException() {
        Mockito.when(celestialObjectRepository.findByName("test")).thenThrow(NotFoundException.class);
        Assertions.assertThrows(NotFoundException.class,()->celestialObjectService.findByName("test"));
    }
}
