package it.cofidimpresa.validator;

import org.springframework.security.core.userdetails.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class InsFinanziamentiValidator  implements Validator{

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
	    
		
	}

}
