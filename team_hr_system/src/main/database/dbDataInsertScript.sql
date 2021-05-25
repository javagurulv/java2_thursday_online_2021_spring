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

INSERT INTO employees
(first_name, last_name, age)
VALUE("Max", "Kel", 25);

INSERT INTO employees
(first_name, last_name, age)
VALUE("Sem", "Cas", 30);

INSERT INTO employees
(first_name, last_name, age)
VALUE("Eek", "Lel", 25);

INSERT INTO employees
(first_name, last_name, age)
VALUE("Xae", "Casd", 22);

INSERT INTO employees
(first_name, last_name, age)
VALUE("Wark", "Kelsis", 23);

INSERT INTO user_employees
(user_id, employee_id, employee_add_date)
VALUE (1001, 1000, NOW());

INSERT INTO user_employees
(user_id, employee_id, employee_add_date)
VALUE (1001, 1001, NOW());

INSERT INTO user_employees
(user_id, employee_id, employee_add_date)
VALUE (1001, 1002, NOW());

INSERT INTO user_employees
(user_id, employee_id, employee_add_date)
VALUE (1001, 1003, NOW());

INSERT INTO user_employees
(user_id, employee_id, employee_add_date)
VALUE (1001, 1004, NOW());