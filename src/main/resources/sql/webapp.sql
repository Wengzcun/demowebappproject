CREATE DATABASE webapp;

CREATE TABLE `user_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(64) DEFAULT NULL,
  `user_name` varchar(64) DEFAULT NULL,
  `phone_number` varchar(64) DEFAULT NULL,
  `universal_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_idx_universal_id` (`universal_id`),
  KEY `idx_user_id` (`user_id`),
  KEY `idx_phone_number` (`phone_number`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;