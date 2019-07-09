CREATE TABLE `cofidimpresanew`.`ateco` (
  `ID_ATECO` INT NOT NULL,
  `CODICE_ATECO` VARCHAR(45) NULL,
  `DESCRIZIONE` VARCHAR(255) CHARACTER SET 'utf8' NULL,
  PRIMARY KEY (`ID_ATECO`),
  UNIQUE INDEX `CODICE_ATECO_UNIQUE` (`CODICE_ATECO` ASC));

  
  CREATE TABLE `cofidimpresanew`.`socio_ateco` (
  `id_socio` INT NOT NULL,
  `id_ateco` INT NOT NULL,
  PRIMARY KEY (`id_socio`, `id_ateco`));