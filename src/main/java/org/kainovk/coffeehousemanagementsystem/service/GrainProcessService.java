package org.kainovk.coffeehousemanagementsystem.service;

import lombok.RequiredArgsConstructor;
import org.kainovk.coffeehousemanagementsystem.dto.BrigadeProcessLost;
import org.kainovk.coffeehousemanagementsystem.dto.CountryProcessLost;
import org.kainovk.coffeehousemanagementsystem.model.Grain;
import org.kainovk.coffeehousemanagementsystem.model.ProcessedGrain;
import org.kainovk.coffeehousemanagementsystem.repository.GrainRepository;
import org.kainovk.coffeehousemanagementsystem.repository.ProcessedGrainRepository;
import org.kainovk.coffeehousemanagementsystem.service.grpc.GrainProcessRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GrainProcessService {

    private final GrainRepository grainRepository;
    private final ProcessedGrainRepository processedGrainRepository;

    @Transactional
    public void process(GrainProcessRequest request) {
        // TODO: validate data

        String grainType = request.getGrainType();
        String countryName = request.getCountryName();
        Grain grain = grainRepository.findFirstByGrainTypeAndCountryName(grainType, countryName)
                .orElseThrow(() -> new RuntimeException("Grain not found"));
        Long newWeight = grain.getWeight() - request.getWeight();
        grain.setWeight(newWeight);
        grainRepository.save(grain);

        ProcessedGrain processedGrain = new ProcessedGrain(
                request.getWeight(),
                request.getFinalWeight(),
                countryName,
                grainType,
                UUID.fromString(request.getBrigadeUUID())
        );
        processedGrainRepository.save(processedGrain);
    }

    public List<BrigadeProcessLost> getProcessLostPercentsByBrigadeId() {
        return processedGrainRepository.getProcessLostPercentsByBrigadeId();
    }

    public List<CountryProcessLost> getProcessLostPercentsByCountryName() {
        return processedGrainRepository.getProcessLostPercentsByCountryName();
    }
}
