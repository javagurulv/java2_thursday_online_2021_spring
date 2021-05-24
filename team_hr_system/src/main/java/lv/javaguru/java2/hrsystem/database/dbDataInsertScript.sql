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
VALUES (1, 4);

INSERT INTO `employee_skills`(`empl_id`, `skill_id`)
VALUES (111, 4);

INSERT INTO `employee_skills`(`empl_id`, `skill_id`)
VALUES (112, 6);

INSERT INTO `employee_skills`(`empl_id`, `skill_id`)
VALUES (114, 1);

INSERT INTO `employee_skills`(`empl_id`, `skill_id`)
VALUES (114, 3);

SELECT * FROM `employees`;

SELECT * FROM `employee_titles`;

SELECT * FROM `skills`;

SELECT * FROM `employee_skills`;

UPDATE `employees`
SET `last_name` = "Test"
WHERE `id` = 111;

select `first_name`, `last_name`, employee_skills.empl_id, employee_skills.skill_id, skills.skill_name
from employees
inner join employee_skills
inner join skills
on employees.id = employee_skills.empl_id
and employee_skills.skill_id = skills.id
order by `first_name` ASC;


update skills
set skill_name = "decision making/problem solving"
where id = 4;

select empl_id, skill_id,  skill_name from `employee_skills`
inner join skills
on employee_skills.skill_id = skills.id;

select * from skills;

ALTER TABLE employee_skills
DROP FOREIGN KEY employee_skills_ibfk_2;

ALTER TABLE employee_skills
ADD FOREIGN KEY (skill_id) REFERENCES skills(id)
ON DELETE CASCADE;

DELETE FROM skills
WHERE id = 4;