SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=1;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=1;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `zero_waste` DEFAULT CHARACTER SET utf8;
USE `zero_waste`;

CREATE TABLE IF NOT EXISTS dish
(
    id          BIGINT       NOT NULL AUTO_INCREMENT,
    name        VARCHAR(100) NOT NULL,
    description VARCHAR(100) NOT NULL,
    type        VARCHAR(100) NOT NULL,
    weight      FLOAT       NOT NULL,
    price       FLOAT       NOT NULL,
    PRIMARY KEY (id)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1001;

CREATE TABLE IF NOT EXISTS product
(
    id         BIGINT       NOT NULL AUTO_INCREMENT,
    name       VARCHAR(100) NOT NULL,
    quantity   FLOAT       NOT NULL,
    price      FLOAT       NOT NULL,
    expiryDate DATE         NOT NULL, /*YYYY-MM-DD*/
    PRIMARY KEY (id)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1001;

CREATE TABLE IF NOT EXISTS ingredient
(
    id          BIGINT       NOT NULL AUTO_INCREMENT,
    product_id  BIGINT       NOT NULL,
    name        VARCHAR(100) NOT NULL,
    quantity    FLOAT        NOT NULL,
    PRIMARY KEY (id)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1;

ALTER TABLE ingredient
ADD FOREIGN KEY (product_id) REFERENCES product (id);

CREATE TABLE IF NOT EXISTS client_list
(
    id          BIGINT       NOT NULL AUTO_INCREMENT,
    name        VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1001;

CREATE TABLE IF NOT EXISTS order_item
(
    id          BIGINT       NOT NULL AUTO_INCREMENT,
	client_id  	BIGINT       NOT NULL,
    dish_id   	BIGINT       NOT NULL,
    quantity    TINYINT		 NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (client_id) REFERENCES client_list (id),
    FOREIGN KEY (dish_id) REFERENCES dish (id)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1001;

CREATE TABLE IF NOT EXISTS order_list
(
    id          BIGINT       NOT NULL AUTO_INCREMENT,
	client_id  	BIGINT       NOT NULL,
    order_date	DATE         NOT NULL, /*YYYY-MM-DD*/
    PRIMARY KEY (id),
    FOREIGN KEY (client_id) REFERENCES client_list (id)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1001;

ALTER TABLE order_list
ADD column order_item_id BIGINT       NOT NULL,
ADD FOREIGN KEY (order_item_id) REFERENCES order_item (id);

CREATE INDEX idx_dish_name_type on dish (name, type);
CREATE UNIQUE INDEX idx_product_name on product (name);
CREATE INDEX idx_client_name on client_list (name);

CREATE TABLE IF NOT EXISTS user_list
(
    id          BIGINT       NOT NULL AUTO_INCREMENT,
    user_role   VARCHAR(100) NOT NULL,
    name        VARCHAR(100) NOT NULL,
    surname     VARCHAR(100) NOT NULL,
    email       VARCHAR(100) NOT NULL,
    password    VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS user_role
(
    id          BIGINT       NOT NULL AUTO_INCREMENT,
    user_role   VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;