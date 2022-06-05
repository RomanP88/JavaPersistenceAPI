DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial, cost int, title VARCHAR(255), PRIMARY KEY (id));
INSERT INTO products (title, cost) VALUES ('Milk', 80), ('Tea', 80), ('Cheese', 80), ('Eggs', 100),('Water', 40),('Fish', 120);
