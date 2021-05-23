INSERT INTO `offer`(type, category, description, price)
VALUES ("Sell", "Land", "Beautiful peace of land. Perfect location.", 20000.50);

INSERT INTO `offer`(type, category, description, price)
VALUES ("Buy", "House", "Looking for 2 bedroom house. Prefered location - Orlando.", 90500.00);

INSERT INTO `offer`(type, category, description, price)
VALUES ("Rent", "Flat", "Looking for a flat to rent with my wife.", 500.00);

INSERT INTO `offer`(type, category, description, price)
VALUES ("Rent", "Flat", "Renting out spaceous flat. Bus stop is 4min away", 300.00);



INSERT INTO `registered_user`(username, password, email)
VALUES ("bigDad10", "password1234", "bigD@gmail.com");

INSERT INTO `registered_user`(username, password, email)
VALUES ("TopShagger", "safestpassever", "gmail@inbox.lv");

INSERT INTO `registered_user`(username, password, email)
VALUES ("realtor300", "makingMoney5", null);



INSERT INTO `user_offers`(registered_user_id, offer_id, offer_create_date)
VALUES (2, 1, '2021-01-01 23:59:59');

INSERT INTO `user_offers`(registered_user_id, offer_id, offer_create_date)
VALUES (2, 3, '2020-02-01 20:50:01');

INSERT INTO `user_offers`(registered_user_id, offer_id, offer_create_date)
VALUES (1, 4, '2021-01-04 21:59:59');

INSERT INTO `user_offers`(registered_user_id, offer_id, offer_create_date)
VALUES (3, 2, '2021-06-01 23:11:59');