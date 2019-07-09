ALTER TABLE `cofidimpresanew`.`antiriciclaggiotmp` 
CHANGE COLUMN `numero_progressivo` `numero_progressivo` INT(11) NULL ,
CHANGE COLUMN `anno_progressivo` `anno_progressivo` YEAR(4) NULL ;


ALTER TABLE `cofidimpresanew`.`antiriciclaggiotmp` 
CHANGE COLUMN `anno_progressivo` `anno_progressivo` INT(4) NULL DEFAULT NULL ;
