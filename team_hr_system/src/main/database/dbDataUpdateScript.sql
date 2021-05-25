SELECT * FROM user_employees
INNER JOIN users ON user_employees.id = users.id
INNER JOIN employees ON user_employees.id = employees.id
WHERE users.user_role = "HR_MANAGER";

UPDATE users
SET user_role = "ADMIN", first_name = "Den", last_name = "QWE"
WHERE id = 1000;

UPDATE users
SET user_role = "HR_MANAGER"
WHERE id = 1000;


UPDATE users_log
SET email = "dimakek@mail.ru",
password = "asdzxc321"
WHERE user_id = 1001;

UPDATE users_log
SET email = "alexmed@mail.ru"
WHERE user_id = 1000;


UPDATE employees
SET first_name = "Ded",
last_name = "Starik",
age = 100
WHERE id = 1000;

UPDATE employees
SET age = 22
WHERE id = 1001;


UPDATE user_employees
SET employee_out_date = '2021-05-27 17:00:00'
WHERE id = 1000;

UPDATE user_employees
SET user_id = 1000,
employee_add_date = '2020-05-27 09:00:00',
employee_out_date = '2021-05-27 17:00:00'
WHERE id = 1003;
