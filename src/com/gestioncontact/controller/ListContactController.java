package com.gestioncontact.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.gestioncontact.modele.Contact;
import com.gestioncontact.service.ContactService;

public class ListContactController extends AbstractController {

	
	private ContactService contactService; 
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		
		String nom=httpServletRequest.getParameter("nom");
		String prenom=httpServletRequest.getParameter("prenom");
		String email=httpServletRequest.getParameter("email");
		
		httpServletRequest.getSession().removeAttribute("contact");
		Map<Long, Contact> contacts=null;
		if(nom==null || "".equals(nom) && (nom==null || "".equals(prenom))  && (email==null || "".equals(email))  ){
			 contacts=contactService.chercherTout();
		}else{
			 contacts=contactService.chercherParNomPrenomMail(nom, prenom, email);
		}
		
		return new ModelAndView().addObject("contacts",contacts);
	}
	/**
	 * @return the contactService
	 */
	public ContactService getContactService() {
		return contactService;
	}
	/**
	 * @param contactService
	 */
	public ListContactController() {
		setSupportedMethods(new String[]{"GET"});
	}
	/**
	 * @param contactService the contactService to set
	 */
	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}

}
