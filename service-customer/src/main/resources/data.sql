CREATE TABLE customers
(
    id         INT NOT NULL AUTO_INCREMENT,
    number_id  INT,
    first_name VARCHAR(60),
    last_name  VARCHAR(60),
    email      VARCHAR(60),
    CONSTRAINT CUSTOMERS_ID_PK PRIMARY KEY (ID)
);

INSERT INTO customers (id, number_id, first_name, last_name, email)
VALUES (1, '1', 'Jorge', 'Perez', 'Jorge@gmail.com');