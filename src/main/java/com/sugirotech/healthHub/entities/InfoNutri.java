package com.sugirotech.healthHub.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "nutri_info")
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

}
