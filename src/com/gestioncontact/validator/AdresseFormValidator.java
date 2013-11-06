package com.gestioncontact.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.gestioncontact.modele.Adresse;

public class AdresseFormValidator implements Validator{

	@Override
	public boolean supports(Class<?> clace) {
		return Adresse.class.isAssignableFrom(clace);
	}

	@Override
	public void validate(Object object, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numero",
				"required.adresseNumero", "Le champs numéro est obligatoire");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rue",
				"required.adresseRue", "Le champs rue est obligatoire");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codePostal",
				"required.adresseCodePostal", "Le champs code postal est obligatoire");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ville",
				"required.adresseVille", "Le champs ville est obligatoire");		
		
	}

}
