package org.kainovk.coffeehousemanagementsystem.controller;

import lombok.RequiredArgsConstructor;
import org.kainovk.coffeehousemanagementsystem.dto.BrigadeProcessLost;
import org.kainovk.coffeehousemanagementsystem.dto.CountryProcessLost;
import org.kainovk.coffeehousemanagementsystem.dto.GrainLeftoversByCountryName;
import org.kainovk.coffeehousemanagementsystem.dto.GrainLeftoversByGrainType;
import org.kainovk.coffeehousemanagementsystem.service.InfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/info")
@RequiredArgsConstructor
public class InfoController {

    private final InfoService infoService;

    @GetMapping("/leftovers/grain-type")
    public List<GrainLeftoversByGrainType> getLeftoversByGrainType() {
        return infoService.getLeftoversByGrainType();
    }

    @GetMapping("/leftovers/country")
    public List<GrainLeftoversByCountryName> getLeftoversByCountryName() {
        return infoService.getLeftoversByCountryName();
    }

    @GetMapping("/brigades/process-lost")
    public List<BrigadeProcessLost> getProcessLostPercentsByBrigadeId() {
        return infoService.getProcessLostPercentsByBrigadeId();
    }

    @GetMapping("/countries/process-lost")
    public List<CountryProcessLost> getProcessLostPercentsByCountryName() {
        return infoService.getProcessLostPercentsByCountryName();
    }
}
