package org.kainovk.coffeehousemanagementsystem.dto.kafka;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GrainIncomeMessage {

    @JsonIgnore
    private Long weight = 60 * 1000L;
    @JsonProperty("country_name")
    private String countryName;
    @JsonProperty("robusta_percentage")
    private short robustaPercentage;
    @JsonProperty("arabica_percentage")
    private short arabicaPercentage;
    @JsonProperty("grain_type")
    private String grainType;
}
