CREATE TABLE nutri(

    id BIGINT NOT NULL AUTO_INCREMENT,
    kilocalories DOUBLE NOT NULL,
    protein DOUBLE NOT NULL,
    carb DOUBLE NOT NULL,
    lipids DOUBLE NOT NULL,
    saturated DOUBLE NOT NULL,
    fibers DOUBLE NOT NULL,

    PRIMARY KEY(id)
);

CREATE TABLE exercise(

    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    rounds INT NOT NULL,
    repetitions INT NOT NULL,
    exercise_interval DOUBLE NOT NULL,
    interval_next DOUBLE NOT NULL,

    PRIMARY KEY(id)
);