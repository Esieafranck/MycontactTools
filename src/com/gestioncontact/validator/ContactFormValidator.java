package com.gestioncontact.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.gestioncontact.modele.Contact;

public class ContactFormValidator implements Validator{

	@Override
	public boolean supports(Class<?> clace) {
		// TODO Auto-generated method stub
		return Contact.class.isAssignableFrom(clace);
	}

	@Override
	public void validate(Object object, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom",
				"required.userNom", "Le champs nom est obligatoire");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prenom",
				"required.userPrenom", "Le champs prénom est obligatoire");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
				"required.userEmail", "Le champs email est obligatoire");
		
	}

}
