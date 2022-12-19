DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial, title VARCHAR(250), price INT, PRIMARY KEY (id));
INSERT INTO products (title, price) VALUES ('milk', 12), ('bread', 10), ('salt', 2), ('sugar', 25), ('butter', 50);
