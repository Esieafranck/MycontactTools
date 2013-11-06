package com.gestioncontact.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.gestioncontact.modele.Adresse;
import com.gestioncontact.modele.Contact;
import com.gestioncontact.service.AdresseService;

public class DeleteAdresseController extends AbstractController{


	/**
	 * {@link AdresseService}
	 */
	private AdresseService adresseService;
	private static final String LIST_VIEW="redirect:contactList.html";
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		long idAdresse=Long.parseLong(httpServletRequest.getParameter("id"));

		Adresse adresse=adresseService.chercherParId(idAdresse);
		Contact contact=(Contact) httpServletRequest.getSession().getAttribute("contact");
		if(adresse!=null && contact!=null){
			adresseService.supprimer(adresse);
			//contact.removeAdresse(adresse);
			return new ModelAndView("redirect:rudContactAction.html?id="+contact.getId()+"&action=display");
		}else{
			return new ModelAndView(LIST_VIEW);
		}




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
