SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=1;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=1;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `humanresources_TEST` DEFAULT CHARACTER SET utf8 ;
USE `humanresources_TEST` ;

CREATE TABLE IF NOT EXISTS `employees` (
`id` BIGINT NOT NULL AUTO_INCREMENT,
`first_name` VARCHAR(200) NOT NULL,
`last_name` VARCHAR(200) NOT NULL,
`age` BIGINT NOT NULL,
`employee_title` VARCHAR(200),
PRIMARY KEY (`id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS `employee_titles` (
`id` BIGINT NOT NULL AUTO_INCREMENT,
`title` VARCHAR(200) NOT NULL,
PRIMARY KEY (`id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1;

DESCRIBE `employee_titles`;

ALTER TABLE `employee_titles`
ADD UNIQUE (`title`);

ALTER TABLE employees
ADD FOREIGN KEY (employee_title) REFERENCES employee_titles(title);

CREATE TABLE IF NOT EXISTS `skills` (
`id` BIGINT NOT NULL AUTO_INCREMENT,
`skill_name` VARCHAR(100) NOT NULL,
PRIMARY KEY (`id`),
UNIQUE (`skill_name`))
ENGINE = InnoDB
AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS `employee_skills` (
`id` BIGINT NOT NULL AUTO_INCREMENT,
`empl_id` BIGINT NOT NULL,
`skill_id` BIGINT NOT NULL,
PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1;

ALTER TABLE `employee_skills`
ADD FOREIGN KEY (`empl_id`) REFERENCES `employees`(`id`);

ALTER TABLE `employee_skills`
ADD FOREIGN KEY (`skill_id`) REFERENCES `skills`(`id`);

CREATE TABLE IF NOT EXISTS users (
id BIGINT NOT NULL AUTO_INCREMENT,
user_role VARCHAR (20) NOT NULL,
first_name VARCHAR (20) NOT NULL,
last_name VARCHAR (20) NOT NULL,
email VARCHAR (30) NOT NULL,
password VARCHAR (20) NOT NULL,
PRIMARY KEY (id)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS user_employees (
id BIGINT NOT NULL AUTO_INCREMENT,
user_id BIGINT NOT NULL,
employee_id BIGINT NOT NULL,
employee_add_date DATETIME NOT NULL,
employee_out_date DATETIME,
PRIMARY KEY (id)
)

ENGINE = InnoDB
AUTO_INCREMENT = 1;

ALTER TABLE user_employees
ADD FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE user_employees
ADD FOREIGN KEY (employee_id) REFERENCES employees (id);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;