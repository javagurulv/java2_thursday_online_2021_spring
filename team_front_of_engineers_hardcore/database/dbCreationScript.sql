SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=1;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=1;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `Auction` DEFAULT CHARACTER SET utf8 ;
USE `Auction` ;
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

CREATE TABLE IF NOT EXISTS `users` (
  `user_id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`user_id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1000;

CREATE TABLE IF NOT EXISTS `user_lots` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `start_price` DECIMAL NOT NULL,
  `user_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`)
  )
ENGINE = InnoDB
AUTO_INCREMENT = 1000;

ALTER TABLE `user_lots`
ADD FOREIGN KEY (`user_id`) REFERENCES `users`(`user_id`);


CREATE TABLE IF NOT EXISTS `user_bets` (
  `id`BIGINT NOT NULL AUTO_INCREMENT,
  `lot_id` BIGINT NOT NULL,
  `bet` DECIMAL NOT NULL,
  `user_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`)
  )ENGINE = InnoDB
AUTO_INCREMENT = 1000;


  ALTER TABLE `user_bets`
  ADD FOREIGN KEY (`lot_id`) REFERENCES `user_lots`(`id`);
  ALTER TABLE `user_bets`
  ADD FOREIGN KEY (`user_id`) REFERENCES `users`(`user_id`);



-- COMMANDS --
SELECT * FROM users;
SELECT * FROM user_lots;
SELECT * FROM user_bets;

-- BY ID --
SELECT user_id,name FROM users;
SELECT id,name FROM user_lots;
SELECT id,lot_id FROM user_bets;

-- BY ONE NON-ID FIELD --
SELECT name FROM users;
SELECT name FROM user_lots;
SELECT bet FROM user_bets;
-- AND OR --
SELECT * FROM users WHERE name = "nameOne" or name = "nameTwo" ;
SELECT * FROM user_lots WHERE name LIKE "b%" OR name LIKE "a%";
SELECT * FROM user_bets WHERE bet > 120 AND bet<270;
-- ORDERING --
   SELECT * FROM user_lots ORDER BY name DESC;
   SELECT * FROM user_lots ORDER BY start_price ASC;
-- LIMIT --
SELECT * FROM user_lots ORDER BY start_price ASC LIMIT 3;



drop schema `Auction`;

