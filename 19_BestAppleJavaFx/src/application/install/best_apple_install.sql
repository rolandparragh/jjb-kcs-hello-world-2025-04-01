CREATE SCHEMA `best_apple` DEFAULT CHARACTER SET utf8 COLLATE utf8_hungarian_ci ;

use best_apple;

CREATE TABLE `best_apple`.`product` (
`id` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(255) NOT NULL,
`price` INT NOT NULL,
`status` tinyint NOT NULL,
PRIMARY KEY (`id`),
UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_hungarian_ci;

CREATE TABLE `best_apple`.`order` (
`id` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(255) NOT NULL,
`email` VARCHAR(255) NOT NULL,
`phone` VARCHAR(255) NOT NULL,
`postal_code` VARCHAR(45) NOT NULL,
`city` VARCHAR(255) NOT NULL,
`address` VARCHAR(255) NOT NULL,
`product_id` INT NOT NULL,
`amount` INT NOT NULL,
PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_hungarian_ci;

ALTER TABLE `best_apple`.`order`
ADD INDEX `id_idx` (`product_id` ASC);
;
ALTER TABLE `best_apple`.`order`
ADD CONSTRAINT `product_id`
FOREIGN KEY (`product_id`)
REFERENCES `best_apple`.`product` (`id`)
ON DELETE RESTRICT
ON UPDATE RESTRICT;

ALTER TABLE `best_apple`.`order` 
ADD COLUMN `reduced` TINYINT(1) NULL DEFAULT 0 AFTER `amount`;

INSERT INTO `best_apple`.`product` (`name`, `price`, `status`) VALUES ('idared', '600', '1');
INSERT INTO `best_apple`.`product` (`name`, `price`, `status`) VALUES ('golden', '700', '1');
INSERT INTO `best_apple`.`product` (`name`, `price`, `status`) VALUES ('jonatán', '650', '1');
