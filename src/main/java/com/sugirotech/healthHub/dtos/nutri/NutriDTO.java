package com.sugirotech.healthHub.dtos.nutri;

import com.sugirotech.healthHub.entities.InfoNutri;

public record NutriDTO(

        Long id,
        Double kilocalories,
        Double protein,
        Double carb,
        Double lipids,
        Double saturated,
        Double fibers

){
    public NutriDTO(InfoNutri data){
        this(data.getId(), data.getKilocalories(),
                data.getProtein(), data.getCarb(),
                data.getLipids(), data.getSaturated(), data.getFibers());
    }
}
