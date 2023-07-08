package org.kainovk.coffeehousemanagementsystem.repository;

import org.kainovk.coffeehousemanagementsystem.dto.BrigadeProcessLost;
import org.kainovk.coffeehousemanagementsystem.dto.CountryProcessLost;
import org.kainovk.coffeehousemanagementsystem.model.ProcessedGrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProcessedGrainRepository extends JpaRepository<ProcessedGrain, Long> {

    @Query("select new org.kainovk.coffeehousemanagementsystem.dto.BrigadeProcessLost(" +
            "pg.brigadeId, AVG(100.0 * (pg.initialWeight - pg.finalWeight) / (pg.initialWeight * 100) * 100)" +
            ") " +
            "from ProcessedGrain pg " +
            "group by pg.brigadeId")
    List<BrigadeProcessLost> getProcessLostPercentsByBrigadeId();

    @Query("select new org.kainovk.coffeehousemanagementsystem.dto.CountryProcessLost(" +
            "pg.countryName, AVG(100.0 * (pg.initialWeight - pg.finalWeight) / (pg.initialWeight * 100) * 100)" +
            ") " +
            "from ProcessedGrain pg " +
            "group by pg.countryName")
    List<CountryProcessLost> getProcessLostPercentsByCountryName();
}
