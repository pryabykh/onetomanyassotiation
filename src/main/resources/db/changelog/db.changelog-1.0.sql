CREATE TABLE petitions
(
    id          BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    title       VARCHAR(255) NOT NULL,
    description TEXT,
    user_id     BIGINT REFERENCES users (id)
);

CREATE TABLE signatures
(
    id          BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    petition_id BIGINT REFERENCES petitions (id),
    user_id     BIGINT REFERENCES users (id),
    created_at TIMESTAMP NOT NULL,
);

CREATE TABLE users
(
    id       BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    username VARCHAR(255) NOT NULL
);

INSERT INTO users (username) VALUES ('Alice');
INSERT INTO users (username) VALUES ('Bob');
INSERT INTO users (username) VALUES ('Charlie');

INSERT INTO petitions (title, description, user_id)
VALUES ('Save the bees',
        'We need to take action to save our declining bee populations. Sign the petition to help!', 1);

INSERT INTO petitions (title, description, user_id)
VALUES ('Clean up the local park',
        'Our local park is in disrepair and needs a good cleaning. Sign the petition to help make it happen!', 2);

INSERT INTO petitions (title, description, user_id)
VALUES ('Support local businesses',
        'Small businesses are the lifeblood of our community. Sign the petition to show your support!', 3);

INSERT INTO signatures (user_id, petition_id, created_at) VALUES (2, 1, '2022-10-10T11:00:00');
INSERT INTO signatures (user_id, petition_id, created_at) VALUES (2, 2, '2022-11-10T11:00:00');
INSERT INTO signatures user_id, (petition_id, created_at) VALUES (3, 1, '2022-10-11T10:00:00');
INSERT INTO signatures user_id, (petition_id, created_at) VALUES (3, 2, '2022-11-10T11:00:00');
INSERT INTO signatures user_id, (petition_id, created_at) VALUES (3, 3, '2022-14-10T11:00:00');