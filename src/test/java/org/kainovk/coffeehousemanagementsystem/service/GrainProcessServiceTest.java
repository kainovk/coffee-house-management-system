package org.kainovk.coffeehousemanagementsystem.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kainovk.coffeehousemanagementsystem.model.Grain;
import org.kainovk.coffeehousemanagementsystem.model.ProcessedGrain;
import org.kainovk.coffeehousemanagementsystem.repository.GrainRepository;
import org.kainovk.coffeehousemanagementsystem.repository.ProcessedGrainRepository;
import org.kainovk.coffeehousemanagementsystem.service.grpc.GrainProcessRequest;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class GrainProcessServiceTest {

    @Mock
    private GrainRepository grainRepository;

    @Mock
    private ProcessedGrainRepository processedGrainRepository;

    private GrainProcessService grainProcessService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        grainProcessService = new GrainProcessService(grainRepository, processedGrainRepository);
    }

    @Test
    void process_ValidRequest_GrainProcessedSuccessfully() {
        Grain grain = new Grain();
        grain.setWeight(1000L);
        String grainType = "Wheat";
        String countryName = "USA";
        when(grainRepository.findFirstByGrainTypeAndCountryName(grainType, countryName))
                .thenReturn(Optional.of(grain));

        GrainProcessRequest request = GrainProcessRequest.newBuilder()
                .setGrainType(grainType)
                .setCountryName(countryName)
                .setWeight(200)
                .setFinalWeight(80)
                .setBrigadeUUID(UUID.randomUUID().toString())
                .build();

        grainProcessService.process(request);

        verify(grainRepository, times(1)).findFirstByGrainTypeAndCountryName(grainType, countryName);
        verify(grainRepository, times(1)).save(grain);
        verify(processedGrainRepository, times(1)).save(any(ProcessedGrain.class));
        assertEquals(800L, grain.getWeight());
    }

    @Test
    void process_GrainNotFound_ThrowsException() {
        String grainType = "Wheat";
        String countryName = "USA";
        when(grainRepository.findFirstByGrainTypeAndCountryName(grainType, countryName))
                .thenReturn(Optional.empty());

        GrainProcessRequest request = GrainProcessRequest.newBuilder()
                .setGrainType(grainType)
                .setCountryName(countryName)
                .setWeight(200)
                .setFinalWeight(80)
                .setBrigadeUUID(UUID.randomUUID().toString())
                .build();

        assertThrows(RuntimeException.class, () -> grainProcessService.process(request));
        verify(grainRepository, times(1)).findFirstByGrainTypeAndCountryName(grainType, countryName);
        verify(grainRepository, never()).save(any(Grain.class));
        verify(processedGrainRepository, never()).save(any(ProcessedGrain.class));
    }
}