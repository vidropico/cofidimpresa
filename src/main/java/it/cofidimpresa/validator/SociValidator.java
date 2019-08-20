package it.cofidimpresa.validator;

import org.springframework.security.core.userdetails.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class SociValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		 ValidationUtils.rejectIfEmpty(errors, "impresa", "error.field.required.soci");
	     ValidationUtils.rejectIfEmpty(errors, "codiceFiscale", "error.field.required.soci");
	     ValidationUtils.rejectIfEmpty(errors, "partitaIva", "error.field.required.soci");
	     ValidationUtils.rejectIfEmpty(errors, "dataCostituzione", "error.field.required.soci");
	     ValidationUtils.rejectIfEmpty(errors, "dataAttivita", "error.field.required.soci");
	     
	     ValidationUtils.rejectIfEmpty(errors, "indirizzoSedeLegale", "error.field.required.soci");
	     ValidationUtils.rejectIfEmpty(errors, "cittaSedeLegale", "error.field.required.soci");
	     ValidationUtils.rejectIfEmpty(errors, "capSedeLegale", "error.field.required.soci");
	     ValidationUtils.rejectIfEmpty(errors, "provinciaSedeLegale", "error.field.required.soci");
	     
	     ValidationUtils.rejectIfEmpty(errors, "nome", "error.field.required.soci");
	     ValidationUtils.rejectIfEmpty(errors, "cognome", "error.field.required.soci");
	     ValidationUtils.rejectIfEmpty(errors, "codiceFiscaleTitolare", "error.field.required.soci");
	     ValidationUtils.rejectIfEmpty(errors, "dataDiNascita", "error.field.required.soci");
	     ValidationUtils.rejectIfEmpty(errors, "luogoDiNascita", "error.field.required.soci");
	     
	     ValidationUtils.rejectIfEmpty(errors, "indirizzoResidenza", "error.field.required.soci");
	     ValidationUtils.rejectIfEmpty(errors, "cittaResidenza", "error.field.required.soci");
	     ValidationUtils.rejectIfEmpty(errors, "capResidenza", "error.field.required.soci");
	     ValidationUtils.rejectIfEmpty(errors, "provinciaResidenza", "error.field.required.soci");
	     
	     ValidationUtils.rejectIfEmpty(errors, "dataInizio", "error.field.required.soci");
	     ValidationUtils.rejectIfEmpty(errors, "cciaa", "error.field.required.soci");
	     ValidationUtils.rejectIfEmpty(errors, "rea", "error.field.required.soci");
	     ValidationUtils.rejectIfEmpty(errors, "tipologiaMerceologica", "error.field.required.soci");

	}

}
