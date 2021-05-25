UPDATE `offer`
SET type = "Sell offer"
WHERE type = "Sell";

UPDATE `offer`
SET price = 1.0
WHERE price = 300.0;

UPDATE `registered_user`
SET password = "12345"
WHERE password = "password1234";

UPDATE `registered_user`
SET email = "hello@good.com"
WHERE email = "gmail@inbox.lv";

UPDATE `user_offers`
SET offer_id = 5
WHERE offer_id = 2;