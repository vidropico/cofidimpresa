package it.cofidimpresa.validator;

import org.springframework.security.core.userdetails.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ModFinanziamentiValidator  implements Validator{

	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		 ValidationUtils.rejectIfEmpty(errors, "importoRichiesto", "error.field.required.finanziamenti");
	     ValidationUtils.rejectIfEmpty(errors, "importoDeliberato", "error.field.required.finanziamenti");
	     ValidationUtils.rejectIfEmpty(errors, "dataApprovazioneConsiglio", "error.field.required.finanziamenti");
	     ValidationUtils.rejectIfEmpty(errors, "percentualeGaranzia", "error.field.required.finanziamenti");
	     ValidationUtils.rejectIfEmpty(errors, "importoGaranzia", "error.field.required.finanziamenti");	     
	     ValidationUtils.rejectIfEmpty(errors, "rateRichieste", "error.field.required.finanziamenti");
	    
	     //ValidationUtils.rejectIfEmpty(errors, "importo", "error.field.required.finanziamenti");
	     //ValidationUtils.rejectIfEmpty(errors, "rate", "error.field.required.finanziamenti");
	     //ValidationUtils.rejectIfEmpty(errors, "importoRata", "error.field.required.finanziamenti");
	     //ValidationUtils.rejectIfEmpty(errors, "dataErogazioneFinanziamento", "error.field.required.finanziamenti");
	     //ValidationUtils.rejectIfEmpty(errors, "dataFineFinanziamento", "error.field.required.finanziamenti");	     
	     //ValidationUtils.rejectIfEmpty(errors, "accredito", "error.field.required.finanziamenti");	     
	     //ValidationUtils.rejectIfEmpty(errors, "impQuotaBanca", "error.field.required.finanziamenti");
	     //ValidationUtils.rejectIfEmpty(errors, "istruttoriaBanca", "error.field.required.finanziamenti");
		
	}

}
