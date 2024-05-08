package com.sugirotech.healthHub.dtos;

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
}
