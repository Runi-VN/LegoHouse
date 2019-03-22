DROP DATABASE IF EXISTS `legohouse`;

CREATE DATABASE  IF NOT EXISTS `legohouse`;

USE `legohouse`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(35) NOT NULL,
  `password` varchar(18) NOT NULL,
  `role` varchar(10) NOT NULL DEFAULT 'customer',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

CREATE TABLE `legohouse`.`orders` (
  `order_id` INT NOT NULL AUTO_INCREMENT,
  `length` INT NOT NULL DEFAULT 0,
  `width` INT NOT NULL DEFAULT 0,
  `height` INT NOT NULL DEFAULT 0,
  `status_sent` BOOLEAN NOT NULL DEFAULT FALSE,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`order_id`),
  INDEX `orders_toUser_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `orders_toUser_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `legohouse`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

ALTER table USER AUTO_INCREMENT = 1;

LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES 
(default,'jens@somewhere.com','jensen','customer'),
(default,'ken@somewhere.com','kensen','customer'),
(default,'robin@somewhere.com','batman','employee'),
(default,'admin@admin.dk', '1234', 'employee'),
(default, 'runiniclasen@hotmail.com', '1234', 'customer');

LOCK TABLES `orders` WRITE;
INSERT INTO `legohouse`.`orders` (`order_id`, `length`, `width`, `height`, `status_sent`, `user_id`) VALUES (default, '10', '10', '1', default, '5');
INSERT INTO `legohouse`.`orders` (`order_id`, `length`, `width`, `height`, `status_sent`, `user_id`) VALUES (default, '10', '10', '2', default, '5');
INSERT INTO `legohouse`.`orders` (`order_id`, `length`, `width`, `height`, `status_sent`, `user_id`) VALUES (default, '20', '20', '1', default, '5');
INSERT INTO `legohouse`.`orders` (`order_id`, `length`, `width`, `height`, `status_sent`, `user_id`) VALUES (default, '20', '20', '2', default, '5');

UNLOCK TABLES;

