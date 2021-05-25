SELECT * FROM users;

SELECT * FROM users
WHERE id = 1000 AND user_role = "ADMIN" OR id =1001 AND user_role = "HR_MANAGER";

SELECT * FROM users
ORDER BY user_role DESC;

SELECT * FROM users LIMIT 5;


SELECT * FROM users_log;

SELECT * FROM users_log
WHERE user_id = 1000 AND password = "qweasd123";

SELECT * FROM users_log
ORDER BY email DESC;

SELECT * FROM users_log LIMIT 5;


SELECT id, email FROM users_log
INNER JOIN users ON users_log.user_id = users.id;

SELECT id, first_name, last_name, email FROM users_log
INNER JOIN users ON users_log.user_id = users.id;


SELECT * FROM employees;

SELECT * FROM employees
WHERE age <= 25;

SELECT * FROM employees
ORDER BY first_name ASC;

SELECT * FROM employees LIMIT 5;

SELECT id, first_name, age FROM employees
ORDER BY age ASC;


SELECT * FROM user_employees;

SELECT * FROM user_employees
WHERE employee_add_date
LIKE "%2021-05-23%";

SELECT * FROM user_employees LIMIT 5;