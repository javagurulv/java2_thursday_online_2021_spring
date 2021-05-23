UPDATE dish
SET type = 'pizza italiana'
WHERE type = 'PIZZA';

UPDATE product
SET expiryDate = '2021-06-03'
WHERE expiryDate = '2021-06-01';

UPDATE ingredient
SET name = 'tomato'
WHERE expiryDate = 'tomatoes';

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