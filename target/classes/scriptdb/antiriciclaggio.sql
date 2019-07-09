ALTER TABLE `cofidimpresanew`.`antiriciclaggio` 
ADD COLUMN `id_finanziamento` INT(11) NULL DEFAULT 0 AFTER `flag_inscompleto`;


ALTER TABLE `cofidimpresanew`.`antiriciclaggiotmp` 
ADD COLUMN `id_finanziamento` INT(11) NULL DEFAULT 0 AFTER `flag_inscompleto`;

ALTER TABLE `cofidimpresanew`.`antiriciclaggiotmp` 
ADD COLUMN `nominativo` VARCHAR(45) NOT NULL AFTER `id_finanziamento`;

ALTER TABLE `cofidimpresanew`.`antiriciclaggio` 
ADD COLUMN `nominativo` VARCHAR(45) NOT NULL AFTER `id_finanziamento`;
