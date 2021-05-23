SELECT * FROM dish;

SELECT * FROM dish WHERE price > 8 AND type = 'PASTA';

SELECT * FROM dish WHERE description LIKE '%ham%';

SELECT * FROM product WHERE expiryDate < '2022-06-15';

SELECT * FROM product WHERE id = 1002;

SELECT * FROM product WHERE quantity < 7;


SELECT * FROM ingredient;

SELECT * FROM ingredient WHERE quantity > 50;

SELECT * FROM ingredient WHERE name LIKE '%ham%';

