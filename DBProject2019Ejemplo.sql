-- MySQL Script generated by MySQL Workbench
-- Mon Sep  2 14:51:24 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema projectdaute2019
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema projectdaute2019
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `projectdaute2019` DEFAULT CHARACTER SET latin1 ;
USE `projectdaute2019` ;

-- -----------------------------------------------------
-- Table `projectdaute2019`.`empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projectdaute2019`.`empleado` (
  `idEmp` INT(11) NOT NULL AUTO_INCREMENT,
  `nombreEmp` VARCHAR(50) NOT NULL,
  `edad` INT(11) NOT NULL,
  `telefono` VARCHAR(50) NULL DEFAULT NULL,
  `direccion` VARCHAR(50) NOT NULL,
  `estado` INT(11) NOT NULL,
  PRIMARY KEY (`idEmp`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `projectdaute2019`.`rrhh`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projectdaute2019`.`rrhh` (
  `id_RRHH` INT(11) NOT NULL AUTO_INCREMENT,
  `nombreRRHH` VARCHAR(50) NOT NULL,
  `descripcion` VARCHAR(50) NULL DEFAULT NULL,
  `estado` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_RRHH`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `projectdaute2019`.`asignacionrrhh`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projectdaute2019`.`asignacionrrhh` (
  `id_Asignacion` INT(11) NOT NULL AUTO_INCREMENT,
  `id_RRHH` INT(11) NOT NULL,
  `id_Empleado` INT(11) NOT NULL,
  `estado` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_Asignacion`),
  UNIQUE INDEX `id_Empleado` (`id_Empleado` ASC) VISIBLE,
  INDEX `fk_id_RRHH1` (`id_RRHH` ASC) VISIBLE,
  CONSTRAINT `fk_id_Empleado`
    FOREIGN KEY (`id_Empleado`)
    REFERENCES `projectdaute2019`.`empleado` (`idEmp`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_id_RRHH1`
    FOREIGN KEY (`id_RRHH`)
    REFERENCES `projectdaute2019`.`rrhh` (`id_RRHH`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `projectdaute2019`.`maquinaria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projectdaute2019`.`maquinaria` (
  `id_Maquinaria` INT(11) NOT NULL AUTO_INCREMENT,
  `nombreMaquinaria` VARCHAR(50) NOT NULL,
  `modelo` VARCHAR(50) NULL DEFAULT NULL,
  `fabricante` VARCHAR(50) NULL DEFAULT NULL,
  `precio` DECIMAL(10,2) NOT NULL,
  `anio` INT(11) NULL DEFAULT NULL,
  `estado` INT(11) NOT NULL,
  `available` INT(11) NOT NULL,
  `cantidad` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id_Maquinaria`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `projectdaute2019`.`proyecto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projectdaute2019`.`proyecto` (
  `id_Proyecto` INT(11) NOT NULL AUTO_INCREMENT,
  `nombreProyecto` VARCHAR(50) NOT NULL,
  `ubicacionProyecto` VARCHAR(50) NOT NULL,
  `fechaInicio` DATE NULL DEFAULT NULL,
  `fechaFin` DATE NULL DEFAULT NULL,
  `tipoProyecto` VARCHAR(50) NOT NULL,
  `inversionInicial` DECIMAL(10,2) NOT NULL,
  `estadoProyecto` VARCHAR(50) NOT NULL,
  `estado` INT(11) NOT NULL,
  PRIMARY KEY (`id_Proyecto`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `projectdaute2019`.`detallemaquinaria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projectdaute2019`.`detallemaquinaria` (
  `id_Detalle_Maquinaria` INT(11) NOT NULL AUTO_INCREMENT,
  `id_Maquinaria` INT(11) NOT NULL,
  `id_Proyecto` INT(11) NOT NULL,
  `cantidad` INT(11) NOT NULL,
  `estado` INT(11) NOT NULL,
  PRIMARY KEY (`id_Detalle_Maquinaria`),
  INDEX `fk_id_Maquinaria` (`id_Maquinaria` ASC) VISIBLE,
  INDEX `fk_id_Proyecto2` (`id_Proyecto` ASC) VISIBLE,
  CONSTRAINT `fk_id_Maquinaria`
    FOREIGN KEY (`id_Maquinaria`)
    REFERENCES `projectdaute2019`.`maquinaria` (`id_Maquinaria`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_id_Proyecto2`
    FOREIGN KEY (`id_Proyecto`)
    REFERENCES `projectdaute2019`.`proyecto` (`id_Proyecto`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 22
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `projectdaute2019`.`materiaprima`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projectdaute2019`.`materiaprima` (
  `id_MateriaP` INT(11) NOT NULL AUTO_INCREMENT,
  `nombreMateria` VARCHAR(50) NOT NULL,
  `DescripcionMateria` VARCHAR(50) NOT NULL,
  `precio` DECIMAL(10,2) NULL DEFAULT NULL,
  `estado` INT(11) NOT NULL,
  PRIMARY KEY (`id_MateriaP`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `projectdaute2019`.`detallemateriap`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projectdaute2019`.`detallemateriap` (
  `id_Detalle_MateriaP` INT(11) NOT NULL AUTO_INCREMENT,
  `id_MateriaP` INT(11) NOT NULL,
  `id_Proyecto` INT(11) NOT NULL,
  `cantidad` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_Detalle_MateriaP`),
  INDEX `fk_id_MateriaP` (`id_MateriaP` ASC) VISIBLE,
  INDEX `fk_id_Proyecto` (`id_Proyecto` ASC) VISIBLE,
  CONSTRAINT `fk_id_MateriaP`
    FOREIGN KEY (`id_MateriaP`)
    REFERENCES `projectdaute2019`.`materiaprima` (`id_MateriaP`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_id_Proyecto`
    FOREIGN KEY (`id_Proyecto`)
    REFERENCES `projectdaute2019`.`proyecto` (`id_Proyecto`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `projectdaute2019`.`detalleproyecto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projectdaute2019`.`detalleproyecto` (
  `id_Detalle_Proyecto` INT(11) NOT NULL AUTO_INCREMENT,
  `id_Proyecto` INT(11) NOT NULL,
  `atrasos` VARCHAR(50) NULL DEFAULT NULL,
  `porcentajeUtilidad` CHAR(6) NULL DEFAULT NULL,
  `porcentajeAvance` CHAR(6) NULL DEFAULT NULL,
  `estado` INT(11) NOT NULL,
  PRIMARY KEY (`id_Detalle_Proyecto`),
  INDEX `fk_id_Proyecto3` (`id_Proyecto` ASC) VISIBLE,
  CONSTRAINT `fk_id_Proyecto3`
    FOREIGN KEY (`id_Proyecto`)
    REFERENCES `projectdaute2019`.`proyecto` (`id_Proyecto`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `projectdaute2019`.`detallerrhh`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projectdaute2019`.`detallerrhh` (
  `id_Detalle_RRHH` INT(11) NOT NULL AUTO_INCREMENT,
  `id_Proyecto` INT(11) NOT NULL,
  `id_AsignacionRRHH` INT(11) NOT NULL,
  `estado` INT(11) NOT NULL,
  PRIMARY KEY (`id_Detalle_RRHH`),
  INDEX `fk_id_Proyecto1` (`id_Proyecto` ASC) VISIBLE,
  INDEX `fk_id_AsignacionRRHH` (`id_AsignacionRRHH` ASC) VISIBLE,
  CONSTRAINT `fk_id_AsignacionRRHH`
    FOREIGN KEY (`id_AsignacionRRHH`)
    REFERENCES `projectdaute2019`.`asignacionrrhh` (`id_Asignacion`),
  CONSTRAINT `fk_id_Proyecto1`
    FOREIGN KEY (`id_Proyecto`)
    REFERENCES `projectdaute2019`.`proyecto` (`id_Proyecto`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 15
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `projectdaute2019`.`rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projectdaute2019`.`rol` (
  `id_Rol` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre_Rol` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id_Rol`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `projectdaute2019`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projectdaute2019`.`user` (
  `id_user` INT(11) NOT NULL AUTO_INCREMENT,
  `fullName` VARCHAR(50) NOT NULL,
  `userName` VARCHAR(50) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  `id_Rol` INT(11) NOT NULL,
  `estado` INT(11) NOT NULL,
  PRIMARY KEY (`id_user`),
  INDEX `fk_id_Rol` (`id_Rol` ASC) VISIBLE,
  CONSTRAINT `fk_id_Rol`
    FOREIGN KEY (`id_Rol`)
    REFERENCES `projectdaute2019`.`rol` (`id_Rol`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;

USE `projectdaute2019` ;

-- -----------------------------------------------------
-- procedure sp_Maquinaria
-- -----------------------------------------------------

DELIMITER $$
USE `projectdaute2019`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Maquinaria`(in id_MaquinariaP int, id_ProyectoP int, cantidadP int, estadoP int )
BEGIN

DECLARE exit handler for sqlexception
  BEGIN
    -- ERROR
  SELECT 'FALSE' AS exito;
  ROLLBACK;
END;

start transaction;
insert into detalleMaquinaria (id_Maquinaria, id_Proyecto, cantidad, estado)
values (id_MaquinariaP, id_ProyectoP, cantidadP, estadoP);

update maquinaria set cantidad = cantidad-cantidadP where id_Maquinaria = id_MaquinariaP;
commit;
SELECT 'TRUE' AS exito;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure sp_MaquinariaModificar
-- -----------------------------------------------------

DELIMITER $$
USE `projectdaute2019`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_MaquinariaModificar`(in id_MaquinariaP int, id_DetalleM int, cantidadP int, cantidadPP int)
BEGIN

DECLARE exit handler for sqlexception
  BEGIN
    -- ERROR
  SELECT 'FALSE' AS exito;
  ROLLBACK;
END;

start transaction;

update maquinaria set cantidad = cantidad+cantidadPP where id_Maquinaria = id_MaquinariaP;

update detalleMaquinaria set id_Maquinaria = id_MaquinariaP, cantidad = cantidadP where id_Detalle_Maquinaria = id_DetalleM;

update maquinaria set cantidad = cantidad-cantidadP where id_Maquinaria = id_MaquinariaP;
commit;
SELECT 'TRUE' AS exito;
END$$

DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
