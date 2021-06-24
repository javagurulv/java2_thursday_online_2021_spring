INSERT INTO  dish(name, description, type, weight, price)
VALUES ('PIZZA 4FORMAGGIO', 'pizza with 4 cheeses', 'PIZZA', 350, 7.99);

INSERT INTO  dish(name, description, type, weight, price)
VALUES ('PIZZA HAWAII', 'pizza with pineapple and ham', 'PIZZA', 400, 9.99);

INSERT INTO  dish(name, description, type, weight, price)
VALUES ('PIZZA MARGHERITA', 'vegetarian pizza with cheese', 'PIZZA', 320, 6.99);

INSERT INTO  dish(name, description, type, weight, price)
VALUES ('PASTA CARBONARA', 'pasta with egg and pepper', 'PASTA', 300, 10.99);



INSERT INTO product(name, quantity, price, expiryDate)
VALUES('flour', 10, 0.5, '2021-12-12');

INSERT INTO product(name, quantity, price, expiryDate)
VALUES('olive oil', 20, 2.25, '2022-06-12');

INSERT INTO product(name, quantity, price, expiryDate)
VALUES('tomatoes', 5, 0.9, '2021-06-01');

INSERT INTO product(name, quantity, price, expiryDate)
VALUES('ham', 3, 4.24, '2021-07-01');




INSERT INTO client_list(name)
VALUE('John Doe');

INSERT INTO client_list(name)
VALUE('Ivan Ivanov');

INSERT INTO client_list(name)
VALUE('Nataliya Petrova');

INSERT INTO client_list(name)
VALUE('Sarah Jones');



INSERT INTO order_item(client_id, dish_id, quantity)
VALUES(1001, 1001, 2);

INSERT INTO order_item(client_id, dish_id, quantity)
VALUES(1002, 1003, 1);

INSERT INTO order_item(client_id, dish_id, quantity)
VALUES(1003, 1004, 1);

INSERT INTO order_item(client_id, dish_id, quantity)
VALUES(1004, 1002, 2);



INSERT INTO order_list(client_id, order_date, order_item_id)
VALUES(1001, '2021-07-01', 1001);

INSERT INTO order_list(client_id, order_date, order_item_id)
VALUES(1002, '2021-07-01', 1003);

INSERT INTO order_list(client_id, order_date, order_item_id)
VALUES(1003, '2021-07-01', 1004);

INSERT INTO order_list(client_id, order_date, order_item_id)
VALUES(1004, '2021-07-01', 1002);

INSERT INTO  dish(id, name, description, type, weight, price)
VALUES (1010, 'PASTA CARBONARA', 'pasta with egg and pepper', 'PASTA', 300, 10.99);


INSERT INTO ingredient(name, quantity, dishId)
VALUES('ham', 30, 1010);

INSERT INTO ingredient(name, quantity, dishId)
VALUES('cheese', 30, 1010);

INSERT INTO ingredient(name, quantity, dishId)
VALUES('fusilli', 120, 1010);

INSERT INTO ingredient(name, quantity, dishId)
VALUES('oil', 10, 1010);

INSERT INTO ingredient(name, quantity, dishId)
VALUES('tomato', 100, 1010);