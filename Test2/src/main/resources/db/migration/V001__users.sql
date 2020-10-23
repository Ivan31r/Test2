CREATE TABLE users
(
    id       SERIAL primary key,
    name     VARCHAR(20) unique,
    password VARCHAR(255)
);

INSERT INTO users (name, password)
VALUES ('user', '$2y$14$FLz0csj1RveyZk/8L3RYSuFmCU193wB83mgD5wyWGU53Ryu/2SBBO');