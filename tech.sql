CREATE DATABASE IF NOT EXISTS techstartpro;

USE techstartpro;

CREATE TABLE IF NOT EXISTS categories (
  id bigint NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL UNIQUE,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS products (
  id bigint NOT NULL AUTO_INCREMENT,
  description varchar(255) NOT NULL,
  name varchar(255) NOT NULL UNIQUE,
  price decimal(10,2) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS products_has_categories (
  product_id bigint NOT NULL,
  category_id bigint NOT NULL,
  PRIMARY KEY(product_id, category_id),
  FOREIGN KEY (product_id) REFERENCES products(id),
  FOREIGN KEY (category_id) REFERENCES categories (id)
);


CREATE USER 'usertechstarpro'@'localhost' IDENTIFIED BY '123456';

GRANT INSERT, UPDATE, DELETE, SELECT ON  techstartpro.* TO 'usertechstarpro'@'localhost';

FLUSH PRIVILEGES;