CREATE DATABASE IF NOT EXISTS computer_store;
USE computer_store;

-- User table
CREATE TABLE IF NOT EXISTS `user` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    `surname` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
);

-- Product table
CREATE TABLE IF NOT EXISTS `product` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    `price` BIGINT NOT NULL,
    `imageUrl` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
);

-- Insert Users
INSERT INTO `user` (`name`, `surname`) VALUES
    ('Ahmet', 'Ak'),
    ('Osman', 'Kara'),
    ('Akif', 'Dege');

-- Insert Products
INSERT INTO `product` (`name`, `price`, `imageUrl`) VALUES
    ('Macbook Pro', 24000, 'https://firebasestorage.googleapis.com/v0/b/marketapp-fd5d2.appspot.com/o/macbook.jpeg?alt=media&token=03aead29-e825-4c14-88b1-10abfb2ea014'),
    ('Lenova', 12000, 'https://firebasestorage.googleapis.com/v0/b/marketapp-fd5d2.appspot.com/o/keyboard.jpeg?alt=media&token=0e40a51b-cc31-430f-a582-b3dcdb1f54aa');

