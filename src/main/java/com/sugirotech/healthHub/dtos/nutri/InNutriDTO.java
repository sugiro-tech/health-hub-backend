package com.sugirotech.healthHub.dtos.nutri;

import com.sugirotech.healthHub.entities.InfoNutri;
import jakarta.validation.constraints.PositiveOrZero;

public record InNutriDTO(
        @PositiveOrZero
        Double kilocalories,
        @PositiveOrZero
        Double protein,
        @PositiveOrZero
        Double carb,
        @PositiveOrZero
        Double lipids,
        @PositiveOrZero
        Double saturated,
        @PositiveOrZero
        Double fibers
) {
        public InNutriDTO(InfoNutri nutri){
                this(nutri.getKilocalories(), nutri.getProtein(),
                        nutri.getCarb(), nutri.getLipids(),
                        nutri.getSaturated(), nutri.getFibers());
        }
}
