package org.kainovk.coffeehousemanagementsystem.repository;

import org.kainovk.coffeehousemanagementsystem.dto.GrainLeftoversByCountryName;
import org.kainovk.coffeehousemanagementsystem.dto.GrainLeftoversByGrainType;
import org.kainovk.coffeehousemanagementsystem.model.Grain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GrainRepository extends JpaRepository<Grain, Long> {

    Optional<Grain> findFirstByGrainTypeAndCountryName(String grainType, String countryName);

    @Query("select new org.kainovk.coffeehousemanagementsystem.dto.GrainLeftoversByGrainType(grain.grainType, sum(grain.weight)) " +
            "from Grain grain " +
            "group by grain.grainType")
    List<GrainLeftoversByGrainType> countAllWeightsByGrainType();

    @Query("select new org.kainovk.coffeehousemanagementsystem.dto.GrainLeftoversByCountryName(grain.countryName, sum(grain.weight)) " +
            "from Grain grain " +
            "group by grain.countryName")
    List<GrainLeftoversByCountryName> countAllWeightsByCountryName();
}
