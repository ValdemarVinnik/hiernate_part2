DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial, title VARCHAR(250), price INT, PRIMARY KEY (id));
INSERT INTO products (title, price) VALUES ('milk', 12), ('bread', 10), ('salt', 2), ('sugar', 25), ('butter', 50);

DROP TABLE customers IF EXISTS;
CREATE TABLE customers (id bigserial, name VARCHAR(250), PRIMARY KEY (id));
INSERT INTO customers (name) VALUES ('Sasha'),('Vova'),('Tanya'),('Olya'),('Petya');

DROP TABLE orders IF EXISTS;
CREATE TABLE orders(product_id INT REFERENCES products (id), customer_id INT REFERENCES customers (id));
INSERT INTO orders (product_id, customer_id) VALUES (1,1),(1,2),(2,5),(2,1),(3,1),(4,3);