
CREATE TABLE retailers IF NOT EXISTS;

CREATE TABLE retailers.user IF NOT EXISTS (user_id BIGINT NOT NULL AUTO_INCREMENT, name VARCHAR(8) NOT NULL, PRIMARY KEY (user_id));
CREATE TABLE retailers.order IF NOT EXISTS (order_id BIGINT NOT NULL AUTO_INCREMENT, user VARCHAR(8), commodity_id INT, PRIMARY KEY (order_id));
CREATE TABLE retailers.commodity IF NOT EXISTS(commodity_id BIGINT NOT NULL AUTO_INCREMENT, conent VARCHAR(100), num BIGINT, , PRIMARY KEY (commodity_id));

