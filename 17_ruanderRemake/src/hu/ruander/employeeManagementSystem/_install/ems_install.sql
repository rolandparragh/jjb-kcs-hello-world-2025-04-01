-- ems adatbázis létrehozása
CREATE SCHEMA `ems` DEFAULT CHARACTER SET utf8 COLLATE utf8_hungarian_ci ;

-- ems adatbázis kiválasztása
use ems;

-- employee_category tábla létrehozása
CREATE TABLE `ems`.`employee_category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `status` TINYINT(1) NULL DEFAULT 1,
  `deleted` TINYINT(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC));

-- employee tábla létrehozása
CREATE TABLE `ems`.`employee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(100) NOT NULL,
  `last_name` VARCHAR(100) NOT NULL,
  `birth_of_date` DATE NULL,
  `identity_card` VARCHAR(45) NULL,
  `salary` INT NULL,
  `employee_category_id` INT NOT NULL,
  `status` TINYINT(1) NULL DEFAULT 1,
  `deleted` TINYINT(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `emp_cat_FK_idx` (`employee_category_id` ASC),
  CONSTRAINT `emp_cat_FK`
    FOREIGN KEY (`employee_category_id`)
    REFERENCES `ems`.`employee_category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- sorok beszúrása employee_category táblába
INSERT INTO `ems`.`employee_category` (`name`) VALUES ('programozó');
INSERT INTO `ems`.`employee_category` (`name`) VALUES ('grafikus');
INSERT INTO `ems`.`employee_category` (`name`) VALUES ('ügyintéző');
INSERT INTO `ems`.`employee_category` (`name`) VALUES ('titkárnő');
INSERT INTO `ems`.`employee_category` (`name`) VALUES ('recepciós');

-- sorok beszúrása employee táblába
INSERT INTO `ems`.`employee` (`first_name`, `last_name`, `birth_of_date`, `identity_card`, `salary`, `employee_category_id`) VALUES ('Elek', 'Teszt', '1999-01-01', '123456AA', '520000', '1');
INSERT INTO `ems`.`employee` (`first_name`, `last_name`, `birth_of_date`, `identity_card`, `salary`, `employee_category_id`, `status`) VALUES ('Jakab', 'Gipsz', '1998-01-02', '142526AG', '480000', '2', '0');
INSERT INTO `ems`.`employee` (`first_name`, `last_name`, `birth_of_date`, `identity_card`, `salary`, `employee_category_id`) VALUES ('Pali', 'Nap', '2001-05-04', '741852RT', '340000', '3');
INSERT INTO `ems`.`employee` (`first_name`, `last_name`, `birth_of_date`, `identity_card`, `salary`, `employee_category_id`, `deleted`) VALUES ('Ica', 'Kukor', '1997-05-01', '789562RA', '250000', '4', '1');

UPDATE `ems`.`employee` SET `employee_category_id` = '2' WHERE (`id` = '1');
UPDATE `ems`.`employee` SET `employee_category_id` = '1' WHERE (`id` = '2');
UPDATE `ems`.`employee` SET `employee_category_id` = '4' WHERE (`id` = '3');
UPDATE `ems`.`employee` SET `employee_category_id` = '5' WHERE (`id` = '4');

ALTER TABLE `ems`.`employee` 
CHANGE COLUMN `birth_of_date` `date_of_birth` DATE NULL DEFAULT NULL ;

