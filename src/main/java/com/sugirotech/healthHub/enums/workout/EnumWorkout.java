package com.sugirotech.healthHub.enums.workout;

import lombok.Getter;

@Getter
public enum EnumWorkout {
    A(EnumMuscleGroup.CHEST, EnumMuscleGroup.SHOULDER, EnumMuscleGroup.TRICEPS),
    B(EnumMuscleGroup.BACK, EnumMuscleGroup.ABDOMEN, EnumMuscleGroup.BICEPS),
    C(EnumMuscleGroup.LEGS, EnumMuscleGroup.GLUTEUS);

    private final EnumMuscleGroup[] muscleGroups;

    // Construtor que pode receber um número variado de argumentos
    // utilizando reticências, decidi usar, pois, no treino C temos apenas dois grupos musculáres

    EnumWorkout(EnumMuscleGroup... muscleGroups){
        this.muscleGroups = muscleGroups;
    }
}
