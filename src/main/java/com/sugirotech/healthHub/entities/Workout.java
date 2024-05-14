package com.sugirotech.healthHub.entities;

import com.sugirotech.healthHub.enums.workout.EnumTrainingOptions;
import com.sugirotech.healthHub.enums.workout.EnumWeekdays;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "workout")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EnumWeekdays weekday;

    @Enumerated(EnumType.STRING)
    private EnumTrainingOptions option;

}
