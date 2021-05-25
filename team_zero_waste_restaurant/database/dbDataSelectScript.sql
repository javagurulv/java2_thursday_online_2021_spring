SELECT * FROM dish;

SELECT * FROM dish WHERE price > 8 AND type = 'PASTA';

SELECT * FROM dish WHERE description LIKE '%ham%';

SELECT * FROM product WHERE expiryDate < '2022-06-15';

SELECT * FROM product WHERE id = 1002;

SELECT * FROM product WHERE quantity < 7;


SELECT * FROM ingredient;

SELECT * FROM ingredient WHERE quantity > 50;

SELECT * FROM ingredient WHERE name LIKE '%ham%';

SELECT * FROM client_list;

SELECT * FROM client_list WHERE id = 1004;

SELECT * FROM client_list WHERE name LIKE '%John%';

SELECT * FROM client_list
	ORDER BY name ASC;

SELECT * FROM client_list
	ORDER BY name ASC
    LIMIT 3;

SELECT * FROM order_item;

SELECT * FROM order_item WHERE client_id BETWEEN 1002 AND 1003;

SELECT * FROM order_item WHERE client_id NOT BETWEEN 1002 AND 1003;

SELECT * FROM order_list;

SELECT * FROM order_list WHERE order_date LIKE '2021-07-01'AND client_id < 1003;

SELECT name FROM client_list USE INDEX (idx_client_name);

SELECT name, type FROM dish USE INDEX (idx_dish_name_type);

SELECT name FROM product USE INDEX (idx_product_name);


