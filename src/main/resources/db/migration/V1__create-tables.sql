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


CREATE TABLE address(
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    street VARCHAR(100) NOT NULL,
    neighborhood VARCHAR(100) NOT NULL,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(100) NOT NULL,
    number BIGINT NOT NULL,

    PRIMARY KEY(id)
);


CREATE TABLE user_professional(
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL,
    password VARCHAR(250) NOT NULL,
    cpf VARCHAR(20) NOT NULL,
    age INT NOT NULL,
    crn_cref VARCHAR(100) NOT NULL,
    role VARCHAR(50) NOT NULL,
    sex VARCHAR(30) NOT NULL,
    rating INT NOT NULL,
    job VARCHAR(40) NOT NULL,

    PRIMARY KEY(id)
);


CREATE TABLE user_client(
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL,
    password VARCHAR(250) NOT NULL,
    cpf VARCHAR(20) NOT NULL,
    age INT NOT NULL,
    crn_cref VARCHAR(100) NOT NULL,
    role VARCHAR(50) NOT NULL,
    sex VARCHAR(30) NOT NULL,

    PRIMARY KEY(id)
);


CREATE TABLE professional_address(
    fk_address BIGINT NOT NULL,
    fk_professional BIGINT NOT NULL,

    PRIMARY KEY(fk_address, fk_professional),

    FOREIGN KEY(fk_address) REFERENCES address(id),
    FOREIGN KEY(fk_professional) REFERENCES user_professional(id)
);

