package org.kainovk.coffeehousemanagementsystem.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public final class GrainLeftoversByGrainType {

    private String grainType;
    private Long weight;

    public GrainLeftoversByGrainType(String grainType, Long weight) {
        this.grainType = grainType;
        this.weight = weight;
    }
}
