
SET SQL_SAFE_UPDATES = 0;

UPDATE finanziamenti SET DATA_FINE_FINANZIAMENTO = null WHERE DATA_FINE_FINANZIAMENTO=0000-00-00
UPDATE finanziamenti SET DATA_EROGAZIONE_FINANZIAMENTO = null WHERE DATA_EROGAZIONE_FINANZIAMENTO=0000-00-00
UPDATE finanziamenti SET DATA_APPROVAZIONE_CONSIGLIO = null WHERE DATA_APPROVAZIONE_CONSIGLIO=0000-00-00

ALTER TABLE `cofidimpresanew`.`finanziamenti` 
ADD COLUMN `RATE_RICHIESTE` VARCHAR(45) CHARACTER SET 'utf8' NULL AFTER `IMPORTO_DELIBERATO`;


ALTER TABLE `cofidimpresanew`.`finanziamenti` 
ADD COLUMN `ACCREDITO` VARCHAR(45) NULL DEFAULT NULL AFTER `RATE_RICHIESTE`,
ADD COLUMN `IMP_QUOTE_BANCA` VARCHAR(45) NULL DEFAULT NULL AFTER `ACCREDITO`,
ADD COLUMN `ISTRUTTORIA_BANCA` VARCHAR(45) NULL DEFAULT NULL AFTER `IMP_QUOTE_BANCA`;

ALTER TABLE `cofidimpresanew`.`finanziamenti` 
ADD COLUMN `FLG_USURA` INT(1) NULL DEFAULT 0 AFTER `ISTRUTTORIA_BANCA`;