DROP DATABASE `legohouse`;

CREATE DATABASE  IF NOT EXISTS `legohouse`;

USE `legohouse`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(90) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(20) NOT NULL DEFAULT 'customer',
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


LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES 
(1,'jens@somewhere.com','jensen','customer'),
(2,'ken@somewhere.com','kensen','customer'),
(3,'robin@somewhere.com','batman','employee');
UNLOCK TABLES;

