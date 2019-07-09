ALTER TABLE `cofidimpresanew`.`profilo` 
ADD COLUMN `ROLE` VARCHAR(45) NOT NULL AFTER `DESCRIZIONE`,

UPDATE `cofidimpresanew`.`profilo` SET `ROLE`='ROLE_ADMIN' WHERE `ID_PROFILO`='1';
UPDATE `cofidimpresanew`.`profilo` SET `ROLE`='ROLE_USER' WHERE `ID_PROFILO`='2';

