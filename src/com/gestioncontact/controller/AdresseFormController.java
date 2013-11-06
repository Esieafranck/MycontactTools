package com.gestioncontact.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.gestioncontact.modele.Adresse;
import com.gestioncontact.modele.Contact;
import com.gestioncontact.service.AdresseService;

public class AdresseFormController extends  SimpleFormController  {

	private AdresseService adresseService; 


	private static final String SUCCESS_VIEW="contactAdresses";
	
	

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
	throws Exception {
		
		Adresse adresse = (Adresse)command;		
		Contact contact= (Contact) request.getSession().getAttribute("contact");
		this.getAdresseService().creer(adresse, contact);
		
		return new ModelAndView(SUCCESS_VIEW);

	}

	
	
	

	/**
	 * @return the contactService
	 */
	public AdresseService getAdresseService() {
		return adresseService;
	}

	/**
	 * @param contactService the contactService to set
	 */
	public void setAdresseService(AdresseService adresseService) {
		this.adresseService = adresseService;
	}

}
