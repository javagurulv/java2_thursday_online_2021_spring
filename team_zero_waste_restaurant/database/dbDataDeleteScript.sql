DELETE FROM product
WHERE price > 4;

DELETE FROM dish
WHERE id = 1004;

DELETE FROM ingredient
WHERE id = 1;

DELETE FROM order_list;

DELETE FROM order_item
WHERE client_id = 1004;

DELETE FROM client_list
WHERE id >= 1004;