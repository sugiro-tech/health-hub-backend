CREATE TABLE nutri(
    id BIGSERIAL PRIMARY KEY,
    kilocalories DOUBLE PRECISION NOT NULL,
    protein DOUBLE PRECISION NOT NULL,
    carb DOUBLE PRECISION NOT NULL,
    lipids DOUBLE PRECISION NOT NULL,
    saturated DOUBLE PRECISION NOT NULL,
    fibers DOUBLE PRECISION NOT NULL
);

CREATE TABLE exercise(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    rounds INT NOT NULL,
    repetitions INT NOT NULL,
    exercise_interval DOUBLE PRECISION NOT NULL,
    interval_next DOUBLE PRECISION NOT NULL
);

CREATE TABLE address(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    street VARCHAR(100) NOT NULL,
    neighborhood VARCHAR(100) NOT NULL,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(100) NOT NULL,
    number BIGINT NOT NULL
);

CREATE TABLE user_professional(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL,
    password VARCHAR(250) NOT NULL,
    cpf VARCHAR(20) NOT NULL,
    age INT NOT NULL,
    crn_cref VARCHAR(100) NOT NULL,
    role VARCHAR(50) NOT NULL,
    sex VARCHAR(30) NOT NULL,
    rating INT NOT NULL,
    job VARCHAR(40) NOT NULL
);

CREATE TABLE user_client(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL,
    password VARCHAR(250) NOT NULL,
    cpf VARCHAR(20) NOT NULL,
    age INT NOT NULL,
    crn_cref VARCHAR(100) NOT NULL,
    role VARCHAR(50) NOT NULL,
    sex VARCHAR(30) NOT NULL
);

CREATE TABLE professional_address(
    fk_address BIGINT NOT NULL,
    fk_professional BIGINT NOT NULL,
    PRIMARY KEY(fk_address, fk_professional),
    FOREIGN KEY(fk_address) REFERENCES address(id),
    FOREIGN KEY(fk_professional) REFERENCES user_professional(id)
);
