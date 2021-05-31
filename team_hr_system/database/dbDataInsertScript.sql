INSERT INTO `employee_titles`(`title`)
VALUES ("BA");

INSERT INTO `employee_titles`(`title`)
VALUES ("developer");

INSERT INTO `employee_titles`(`title`)
VALUES ("manager");

INSERT INTO `employee_titles`(`title`)
VALUES ("QA_engineer");

INSERT INTO `employee_titles`(`title`)
VALUES ("SALES_MANAGER");

INSERT INTO `employees`(`first_name`, `last_name`, `age`, `employee_title`)
VALUES ("Tom", "Smith", 45, "BA");

INSERT INTO `employees`(`first_name`, `last_name`, `age`)
VALUES ("John", "Smith", 25);

INSERT INTO `employees`(`first_name`, `last_name`, `age`, `employee_title`)
VALUES ("Tom", "Smith", 45, "BA");

INSERT INTO `employees`(`id`, `first_name`, `last_name`, `age`)
VALUES (111, "Robert", "Custom", 35);

INSERT INTO `employees`(`first_name`, `last_name`, `age`, `employee_title`)
VALUES ("Aaa", "Bbbbb", 30, "QA_engineer");

INSERT INTO `employees`(`first_name`, `last_name`, `age`, `employee_title`)
VALUES ("Ccc", "Dddddd", 26, "QA_engineer");

INSERT INTO `employees`(`first_name`, `last_name`, `age`, `employee_title`)
VALUES ("Eee", "Fffff", 46, "SALES_MANAGER");

INSERT INTO `skills`(`skill_name`)
VALUES ("testing");

INSERT INTO `skills`(`skill_name`)
VALUES ("sales");

INSERT INTO `skills`(`skill_name`)
VALUES ("management");

INSERT INTO `skills`(`skill_name`)
VALUES ("decision making");

INSERT INTO `skills`(`skill_name`)
VALUES ("math");

INSERT INTO `skills`(`skill_name`)
VALUES ("financial");

INSERT INTO `employee_skills`(`empl_id`, `skill_id`)
VALUES (3, 4);

INSERT INTO `employee_skills`(`empl_id`, `skill_id`)
VALUES (111, 4);

INSERT INTO `employee_skills`(`empl_id`, `skill_id`)
VALUES (112, 6);

INSERT INTO `employee_skills`(`empl_id`, `skill_id`)
VALUES (114, 1);

INSERT INTO `employee_skills`(`empl_id`, `skill_id`)
VALUES (114, 3);

INSERT INTO users
(user_role, first_name, last_name)
VALUE("ADMIN", "ALEX", "MED");

INSERT INTO users
(user_role, first_name, last_name)
VALUE("HR_MANAGER", "DIMA", "KEK");

INSERT INTO users_log
VALUE(1000, "alexmed@gmail.com", "qweasd123");

INSERT INTO users_log
VALUE(1001, "dimakek@gmail.com", "qweasd123");

INSERT INTO user_employees
(user_id, employee_id, employee_add_date)
VALUE (1001, 3, NOW());

INSERT INTO user_employees
(user_id, employee_id, employee_add_date)
VALUE (1001, 111, NOW());

INSERT INTO user_employees
(user_id, employee_id, employee_add_date)
VALUE (1001, 112, NOW());

INSERT INTO user_employees
(user_id, employee_id, employee_add_date)
VALUE (1001, 113, NOW());

DELETE FROM skills
WHERE id = 4;

ALTER TABLE employee_skills
DROP FOREIGN KEY employee_skills_ibfk_2;

ALTER TABLE employee_skills
ADD FOREIGN KEY (skill_id) REFERENCES skills(id)
ON DELETE CASCADE;