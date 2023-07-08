package org.kainovk.coffeehousemanagementsystem.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class BrigadeProcessLost {

    private UUID brigadeId;
    private double lostPercent;

    public BrigadeProcessLost(UUID brigadeId, double lostPercent) {
        this.brigadeId = brigadeId;
        this.lostPercent = lostPercent;
    }
}
