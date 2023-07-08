package org.kainovk.coffeehousemanagementsystem.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CountryProcessLost {

    private String countryName;
    private double lostPercent;

    public CountryProcessLost(String countryName, double lostPercent) {
        this.countryName = countryName;
        this.lostPercent = lostPercent;
    }
}
