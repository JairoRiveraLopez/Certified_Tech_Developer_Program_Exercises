-- MySQL Script generated by MySQL Workbench
-- Mon Feb 21 13:47:53 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema saluddh
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema saluddh
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `saluddh` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `saluddh` ;

-- -----------------------------------------------------
-- Table `saluddh`.`especialidad`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `saluddh`.`especialidad` ;

CREATE TABLE IF NOT EXISTS `saluddh`.`especialidad` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `saluddh`.`medicos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `saluddh`.`medicos` ;

CREATE TABLE IF NOT EXISTS `saluddh`.`medicos` (
  `idmedico` INT NOT NULL,
  `nombre` VARCHAR(100) NOT NULL,
  `apellido` VARCHAR(100) NOT NULL,
  `matricula` INT NOT NULL,
  `idespecialidad` INT NOT NULL,
  PRIMARY KEY (`idmedico`),
  INDEX `FKespecialidad_idx` (`idespecialidad` ASC) VISIBLE,
  CONSTRAINT `id_especialidad`
    FOREIGN KEY (`idespecialidad`)
    REFERENCES `saluddh`.`especialidad` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `saluddh`.`pacientes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `saluddh`.`pacientes` ;

CREATE TABLE IF NOT EXISTS `saluddh`.`pacientes` (
  `idpaciente` INT NOT NULL,
  `nombre` VARCHAR(100) NOT NULL,
  `apellido` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idpaciente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `saluddh`.`turno`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `saluddh`.`turno` ;

CREATE TABLE IF NOT EXISTS `saluddh`.`turno` (
  `id` INT NOT NULL,
  `id_medico` INT NOT NULL,
  `id_paciente` INT NOT NULL,
  `fecha` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `medico_idx` (`id_medico` ASC) VISIBLE,
  INDEX `paciente_idx` (`id_paciente` ASC) VISIBLE,
  CONSTRAINT `id_medico`
    FOREIGN KEY (`id_medico`)
    REFERENCES `saluddh`.`medicos` (`idmedico`),
  CONSTRAINT `id_paciente`
    FOREIGN KEY (`id_paciente`)
    REFERENCES `saluddh`.`pacientes` (`idpaciente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
