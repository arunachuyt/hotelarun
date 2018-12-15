SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `onlinehotel` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `onlinehotel` ;

-- -----------------------------------------------------
-- Table `onlinehotel`.`Location`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `onlinehotel`.`Location` (
  `location_id` INT NULL AUTO_INCREMENT ,
  `location_name` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`location_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlinehotel`.`Admin`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `onlinehotel`.`Admin` (
  `username` VARCHAR(45) NOT NULL ,
  `password` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`username`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlinehotel`.`Customer`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `onlinehotel`.`Customer` (
  `phone_no` varchar(10) NOT NULL ,
  `cust_name` VARCHAR(45) NOT NULL ,
  `password` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`phone_no`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlinehotel`.`RoomType`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `onlinehotel`.`RoomType` (
  `type_id` INT NULL AUTO_INCREMENT ,
  `type` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`type_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlinehotel`.`Hotel`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `onlinehotel`.`Hotel` (
  `hotel_id` INT NULL AUTO_INCREMENT ,
  `hotel_name` VARCHAR(45) NOT NULL ,
  `Location_location_id` INT NOT NULL ,
  PRIMARY KEY (`hotel_id`) ,
  INDEX `fk_Hotel_Location_idx` (`Location_location_id` ASC) ,
  CONSTRAINT `fk_Hotel_Location`
    FOREIGN KEY (`Location_location_id` )
    REFERENCES `onlinehotel`.`Location` (`location_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlinehotel`.`Room`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `onlinehotel`.`Room` (
  `room_id` INT NULL AUTO_INCREMENT ,
  `price` DOUBLE NOT NULL ,
  `Hotel_hotel_id` INT NOT NULL ,
  `RoomType_type_id` INT NOT NULL ,
  PRIMARY KEY (`room_id`) ,
  INDEX `fk_Room_Hotel1_idx` (`Hotel_hotel_id` ASC) ,
  INDEX `fk_Room_RoomType1_idx` (`RoomType_type_id` ASC) ,
  CONSTRAINT `fk_Room_Hotel1`
    FOREIGN KEY (`Hotel_hotel_id` )
    REFERENCES `onlinehotel`.`Hotel` (`hotel_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Room_RoomType1`
    FOREIGN KEY (`RoomType_type_id` )
    REFERENCES `onlinehotel`.`RoomType` (`type_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlinehotel`.`BookingEntry`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `onlinehotel`.`BookingEntry` (
  `bid` INT NULL AUTO_INCREMENT ,
  `booking_date` DATE NOT NULL ,
  `Customer_phone_no` varchar(10) NOT NULL ,
  PRIMARY KEY (`bid`) ,
  INDEX `fk_BookingEntry_Customer1_idx` (`Customer_phone_no` ASC) ,
  CONSTRAINT `fk_BookingEntry_Customer1`
    FOREIGN KEY (`Customer_phone_no` )
    REFERENCES `onlinehotel`.`Customer` (`phone_no` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlinehotel`.`BookingDetails`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `onlinehotel`.`BookingDetails` (
  `check_in` DATE NOT NULL ,
  `check_out` DATE NOT NULL ,
  `BookingEntry_bid` INT NOT NULL ,
  `Room_room_id` INT NULL ,
  PRIMARY KEY (`BookingEntry_bid`, `Room_room_id`) ,
  INDEX `fk_BookingDetails_Room1_idx` (`Room_room_id` ASC) ,
  CONSTRAINT `fk_BookingDetails_BookingEntry1`
    FOREIGN KEY (`BookingEntry_bid` )
    REFERENCES `onlinehotel`.`BookingEntry` (`bid` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_BookingDetails_Room1`
    FOREIGN KEY (`Room_room_id` )
    REFERENCES `onlinehotel`.`Room` (`room_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `onlinehotel` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
