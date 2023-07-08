package org.kainovk.coffeehousemanagementsystem.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public final class GrainLeftoversByCountryName {

    private String countryName;
    private Long weight;

    public GrainLeftoversByCountryName(String countryName, Long weight) {
        this.countryName = countryName;
        this.weight = weight;
    }
}
