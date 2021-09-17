CREATE TABLE CATEGORIES
(
    id   INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50),
    CONSTRAINT CATEGORIES_ID_PK PRIMARY KEY (ID)
);

CREATE TABLE PRODUCTS
(
    id          INT NOT NULL AUTO_INCREMENT,
    name        VARCHAR(60),
    price       INT,
    stock       INT,
    category_id INT,
    CONSTRAINT PRODUCTS_ID_PK PRIMARY KEY (ID),
    CONSTRAINT PRODUCTS_CATEGORY_FK FOREIGN KEY (category_id) REFERENCES CATEGORIES (id)
);

INSERT INTO categories (id, name)
VALUES (1, 'Hombre');
INSERT INTO categories (id, name)
VALUES (2, 'Mujer');
INSERT INTO categories (id, name)
VALUES (3, 'Niñ@');

INSERT INTO products (id, name, price, stock, category_id)
VALUES (1, 'Guayos', 10, 10, 1);

INSERT INTO products (id, name, price, stock, category_id)
VALUES (2, 'Bolso', 20, 20, 2);

INSERT INTO products (id, name, price, stock, category_id)
VALUES (3, 'Balon', 30, 30, 3);