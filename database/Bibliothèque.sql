SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bibliothèque
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bibliothèque` DEFAULT CHARACTER SET utf8 ;
USE `bibliothèque` ;

-- -----------------------------------------------------
-- Table `bibliothèque`.`etudiant`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bibliothèque`.`etudiant` (
  `idEtudiant` INT(11) NOT NULL,
  `Nom` VARCHAR(45) NULL DEFAULT NULL,
  `Prenom` VARCHAR(45) NULL DEFAULT NULL,
  `Tel` VARCHAR(45) NULL DEFAULT NULL,
  `Niveau` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idEtudiant`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bibliothèque`.`livre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bibliothèque`.`livre` (
  `idLivre` INT(11) NOT NULL,
  `Titre` VARCHAR(45) NULL DEFAULT NULL,
  `Auteur` VARCHAR(45) NULL DEFAULT NULL,
  `DateEmprunt` VARCHAR(45) NULL DEFAULT NULL,
  `Edition` VARCHAR(45) NULL DEFAULT NULL,
  `idEtudiant` INT(11) NOT NULL,
  PRIMARY KEY (`idLivre`),
  INDEX `fk_livre_etudiant_idx` (`idEtudiant` ASC),
  CONSTRAINT `fk_livre_etudiant`
    FOREIGN KEY (`idEtudiant`)
    REFERENCES `bibliothèque`.`etudiant` (`idEtudiant`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
