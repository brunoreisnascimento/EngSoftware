DROP SCHEMA IF EXISTS `websearch` ;


CREATE SCHEMA IF NOT EXISTS `websearch` DEFAULT CHARACTER SET utf8 ;
USE `websearch` ;

-- -----------------------------------------------------
-- Tabela site
-- -----------------------------------------------------
DROP TABLE IF EXISTS `websearch`.`site` ;

CREATE TABLE IF NOT EXISTS `websearch`.`site` (
  `url` VARCHAR(255) NOT NULL,
  `tags` VARCHAR(255) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`url`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `url_UNIQUE` ON `websearch`.`site` (`url` ASC);


-- -----------------------------------------------------
-- Tabela news
-- -----------------------------------------------------
DROP TABLE IF EXISTS `websearch`.`news` ;

CREATE TABLE IF NOT EXISTS `websearch`.`news` (
  `url` VARCHAR(255) NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  `dataNoticia` CHAR(10) NOT NULL,
  PRIMARY KEY (`url`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Tabela login
-- -----------------------------------------------------
DROP TABLE IF EXISTS `websearch`.`login` ;

CREATE TABLE IF NOT EXISTS `websearch`.`login` (
  `user` VARCHAR(20) NOT NULL,
  `pass` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Inserts tabela site
-- -----------------------------------------------------
START TRANSACTION;
USE `websearch`;
INSERT INTO `websearch`.`site` (`url`, `tags`, `nome`) VALUES ('http://br-linux.org', 'div.post, h2, postmetadata', 'brLinux');
INSERT INTO `websearch`.`site` (`url`, `tags`, `nome`) VALUES ('http://olhardigital.uol.com.br/noticias/', 'div.item, h3, date', 'olharDigital');
INSERT INTO `websearch`.`site` (`url`, `tags`, `nome`) VALUES ('http://www.profissionaisti.com.br/ultimas-ti/', 'div.entry-content-with-thumbnail, h2, span', 'profissionaisTi');

COMMIT;


