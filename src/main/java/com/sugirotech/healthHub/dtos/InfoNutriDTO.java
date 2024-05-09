package com.sugirotech.healthHub.dtos;

import com.sugirotech.healthHub.entities.InfoNutri;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public record InfoNutriDTO(
        @PositiveOrZero
        @NotBlank
        Double kilocalories,
        @PositiveOrZero
        @NotBlank
        Double protein,
        @PositiveOrZero
        @NotBlank
        Double carb,
        @PositiveOrZero
        @NotBlank
        Double lipids,
        @PositiveOrZero
        @NotBlank
        Double saturated,
        @PositiveOrZero
        @NotBlank
        Double fibers
) {
        public InfoNutriDTO(InfoNutri nutri){
                this(nutri.getKilocalories(), nutri.getProtein(),
                        nutri.getCarb(), nutri.getLipids(),
                        nutri.getSaturated(), nutri.getFibers());
        }
}
