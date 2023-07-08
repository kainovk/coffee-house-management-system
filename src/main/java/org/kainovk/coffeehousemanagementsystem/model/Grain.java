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

@Entity
@Table(name = "grain")
@NoArgsConstructor
@Getter
@Setter
public class Grain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "weight")
    private Long weight;

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "robusta_percentage")
    private short robustaPercentage;

    @Column(name = "arabica_percentage")
    private short arabicaPercentage;

    @Column(name = "grain_type")
    private String grainType;

    public Grain(Long weight, String countryName, short robustaPercentage, short arabicaPercentage, String grainType) {
        this.weight = weight;
        this.countryName = countryName;
        this.robustaPercentage = robustaPercentage;
        this.arabicaPercentage = arabicaPercentage;
        this.grainType = grainType;
    }
}
