SELECT * FROM `offer`;

SELECT * FROM `offer` WHERE price > 10000;

SELECT * FROM `offer` WHERE price < 1000 AND category = "Flat";

SELECT * FROM `offer` WHERE type = "Rent";

SELECT * FROM `registered_user`;

SELECT * FROM `registered_user` WHERE username = "TopShagger";

SELECT * FROM `user_offers`;

SELECT * FROM `user_offers` WHERE registered_user_id = 2;

SELECT * FROM `user_offers` WHERE offer_id = 4;