package org.kainovk.coffeehousemanagementsystem.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "processed_grain")
@NoArgsConstructor
@Getter
@Setter
public class ProcessedGrain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "initial_weight")
    private Long initialWeight;

    @Column(name = "final_weight")
    private Long finalWeight;

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "grain_type")
    private String grainType;

    @Column(name = "brigade_id")
    private UUID brigadeId;

    public ProcessedGrain(Long initialWeight, Long finalWeight, String countryName, String grainType, UUID brigadeId) {
        this.initialWeight = initialWeight;
        this.finalWeight = finalWeight;
        this.countryName = countryName;
        this.grainType = grainType;
        this.brigadeId = brigadeId;
    }
}
