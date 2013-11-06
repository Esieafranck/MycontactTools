package com.gestioncontact.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.gestioncontact.modele.Adresse;
import com.gestioncontact.modele.Contact;
import com.gestioncontact.service.AdresseService;
import com.gestioncontact.service.ContactService;

public class RudContactController  extends AbstractController{


	private static final String LIST_VIEW="redirect:contactList.html";

	private static final String DELETE_ACTION="delete";
	private static final String UPDATE_ACTION="update";
	private static final String READ_ALL_ACTION="display";
	private static final String 	DELETE_ALL_ACTION="deleteAll";
	private ContactService contactService;
	private AdresseService adresseService;
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		ModelAndView mav=new ModelAndView(LIST_VIEW);
		String id=httpServletRequest.getParameter("id");
		String action=httpServletRequest.getParameter("action");
		 httpServletRequest.getSession().removeAttribute("contact");
		if(id==null){
			if(DELETE_ALL_ACTION.equals(action)){
				adresseService.supprimerTout();
				contactService.supprimerTout();
			}
		}else{
			try {
				Contact contact=contactService.chercherParId(Long.parseLong(id));

				if(contact!=null){
					if(DELETE_ACTION.equals(action)){
						adresseService.supprimerAdresse(contact.getAdresses());
						contactService.supprimer(contact);
					}else if(UPDATE_ACTION.equals(action)){
						//update view with objet 
						httpServletRequest.getSession().setAttribute("contact", contact);
						mav=new ModelAndView("redirect:ajouterContactForm.html","contact",contact);
						
					}else if(READ_ALL_ACTION.equals(action)){
						this.getAdresseService().chercherParContact(contact);
						httpServletRequest.getSession().setAttribute("contact", contact);
						mav=new ModelAndView("contactAdresses","contact",contact);
						mav.addObject(new Adresse());
					}


				}	
			} catch (NumberFormatException e) {

			}

		}


		return mav;
	}



	/**
	 * @return the contactService
	 */
	public ContactService getContactService() {
		return contactService;
	}
	/**
	 * @param contactService the contactService to set
	 */
	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}



	/**
	 * @return the adresseService
	 */
	public AdresseService getAdresseService() {
		return adresseService;
	}



	/**
	 * @param adresseService the adresseService to set
	 */
	public void setAdresseService(AdresseService adresseService) {
		this.adresseService = adresseService;
	}
}
