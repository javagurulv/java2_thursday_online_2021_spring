UPDATE dish
SET type = 'pizza italiana'
WHERE type = 'PIZZA';

UPDATE product
SET expiryDate = '2021-06-03'
WHERE expiryDate = '2021-06-01';

UPDATE ingredient
SET name = 'tomato'
WHERE name = 'tomatoes';

UPDATE client_list
SET name = 'Sarah Johnes-Miller'
WHERE id = 1004;

UPDATE client_list
SET name = 'Sarah Johnes-Miller'
WHERE name = 'Sarah Miller';

UPDATE order_list
SET order_date = '2021-07-02';

UPDATE order_item
SET client_id = 1004
WHERE client_id = 1001;

ALTER TABLE dish
MODIFY description varchar (300);

ALTER TABLE ingredient
DROP foreign key ingredient_ibfk_1;

ALTER TABLE ingredient
DROP product_id;

ALTER TABLE order_list
DROP foreign key order_list_ibfk_2;

ALTER TABLE order_list
DROP order_item_id;

ALTER TABLE order_item
DROP foreign key order_item_ibfk_1;

ALTER TABLE order_item
DROP client_id;

ALTER TABLE order_item
ADD column order_list_id BIGINT       NOT NULL,
ADD FOREIGN KEY (order_list_id) REFERENCES order_list (id);

ALTER TABLE user_list
ADD FOREIGN KEY (user_role) REFERENCES user_role (id);

ALTER TABLE dish
ADD COLUMN isInActiveMenu BIT DEFAULT 1;

CREATE INDEX idx_user_list_name_surname_email on user_list (name, surname, email);

ALTER TABLE ingredient ADD COLUMN dishId BIGINT not null;

CREATE TABLE IF NOT EXISTS dish_ingredient AS

    SELECT dish.name AS restaurant_dish, ingredient.name, ingredient.quantity
    FROM ingredient
             JOIN dish on ingredient.dishId = dish.id;