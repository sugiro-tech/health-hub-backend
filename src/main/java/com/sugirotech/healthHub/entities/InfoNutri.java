package com.sugirotech.healthHub.entities;

import com.sugirotech.healthHub.dtos.nutri.InNutriDTO;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "nutri")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class InfoNutri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double kilocalories;
    private Double protein;
    private Double carb;
    private Double lipids;
    private Double saturated;
    private Double fibers;

    public InfoNutri(InNutriDTO data) {
        this.kilocalories = data.kilocalories();
        this.protein = data.protein();
        this.carb = data.carb();
        this.lipids = data.lipids();
        this.saturated = data.saturated();
        this.fibers = data.fibers();
    }
}
