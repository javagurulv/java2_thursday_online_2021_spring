SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=1;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=1;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `zero_waste` DEFAULT CHARACTER SET utf8;
USE `zero_waste`;

CREATE TABLE IF NOT EXISTS dish
(
    id             BIGINT       NOT NULL AUTO_INCREMENT,
    name           VARCHAR(100) NOT NULL,
    description    VARCHAR(300) NOT NULL,
    type           VARCHAR(100) NOT NULL,
    weight         FLOAT        NOT NULL,
    price          FLOAT        NOT NULL,
    isInActiveMenu BIT DEFAULT  1,
    PRIMARY KEY (id)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS product
(
    id         BIGINT       NOT NULL AUTO_INCREMENT,
    name       VARCHAR(100) NOT NULL,
    quantity   FLOAT        NOT NULL,
    price      FLOAT        NOT NULL,
    expiryDate DATE         NOT NULL, /*YYYY-MM-DD*/
    PRIMARY KEY (id)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS ingredient
(
    id          BIGINT       NOT NULL AUTO_INCREMENT,
    dish_id   	BIGINT       NOT NULL,
    name        VARCHAR(100) NOT NULL,
    quantity    FLOAT        NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (dish_id) REFERENCES dish (id)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1;

    CREATE TABLE IF NOT EXISTS users
(
    id            BIGINT        NOT NULL AUTO_INCREMENT,
    user_role     VARCHAR(20)   NOT NULL,
    name          VARCHAR(100)  NOT NULL,
    surname       VARCHAR(100)  NOT NULL,
    email         VARCHAR(100)  NOT NULL,
    password      VARCHAR(100)  NOT NULL,
    PRIMARY KEY (id)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1;


CREATE TABLE IF NOT EXISTS orders
(
    id             BIGINT       NOT NULL AUTO_INCREMENT,
	user_id  	   BIGINT       NOT NULL,
    order_date	   DATE         NOT NULL, /*YYYY-MM-DD*/
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1;


CREATE TABLE IF NOT EXISTS order_item
(
    id          BIGINT       NOT NULL AUTO_INCREMENT,
	order_id  	BIGINT       NOT NULL,
    dish_id   	BIGINT       NOT NULL,
    quantity    INT			 NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (order_id) REFERENCES orders (id),
    FOREIGN KEY (dish_id) REFERENCES dish (id)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1;


CREATE TABLE IF NOT EXISTS dish_ingredients AS

    SELECT dish.name AS restaurant_dish, ingredient.name, ingredient.quantity
    FROM ingredient
             JOIN dish on ingredient.dish_id = dish.id;


CREATE UNIQUE INDEX idx_dish_name_type on dish (name, type);
CREATE UNIQUE INDEX idx_product_name on product (name);
CREATE UNIQUE INDEX idx_ingredient_name on ingredient (name);
CREATE UNIQUE INDEX idx_user_email_password on users (email, password);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;