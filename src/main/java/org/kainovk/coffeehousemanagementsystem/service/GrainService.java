package org.kainovk.coffeehousemanagementsystem.service;

import lombok.RequiredArgsConstructor;
import org.kainovk.coffeehousemanagementsystem.dto.GrainLeftoversByCountryName;
import org.kainovk.coffeehousemanagementsystem.dto.GrainLeftoversByGrainType;
import org.kainovk.coffeehousemanagementsystem.dto.kafka.GrainIncomeMessage;
import org.kainovk.coffeehousemanagementsystem.model.Grain;
import org.kainovk.coffeehousemanagementsystem.repository.GrainRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GrainService {

    private final GrainRepository grainRepository;
    private final ModelMapper modelMapper;

    public void save(GrainIncomeMessage message) {
        Grain grain = modelMapper.map(message, Grain.class);
        grainRepository.save(grain);
    }

    public List<GrainLeftoversByGrainType> getLeftoversByGrainType() {
        return grainRepository.countAllWeightsByGrainType();
    }

    public List<GrainLeftoversByCountryName> getLeftoversByCountryName() {
        return grainRepository.countAllWeightsByCountryName();
    }
}
