package org.kainovk.coffeehousemanagementsystem.service;

import lombok.RequiredArgsConstructor;
import org.kainovk.coffeehousemanagementsystem.dto.BrigadeProcessLost;
import org.kainovk.coffeehousemanagementsystem.dto.CountryProcessLost;
import org.kainovk.coffeehousemanagementsystem.dto.GrainLeftoversByCountryName;
import org.kainovk.coffeehousemanagementsystem.dto.GrainLeftoversByGrainType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InfoService {

    private final GrainService grainService;
    private final GrainProcessService grainProcessService;

    public List<GrainLeftoversByGrainType> getLeftoversByGrainType() {
        return grainService.getLeftoversByGrainType();
    }

    public List<GrainLeftoversByCountryName> getLeftoversByCountryName() {
        return grainService.getLeftoversByCountryName();
    }

    public List<BrigadeProcessLost> getProcessLostPercentsByBrigadeId() {
        return grainProcessService.getProcessLostPercentsByBrigadeId();
    }

    public List<CountryProcessLost> getProcessLostPercentsByCountryName() {
        return grainProcessService.getProcessLostPercentsByCountryName();
    }
}
