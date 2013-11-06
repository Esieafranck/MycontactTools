package com.gestioncontact.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.gestioncontact.modele.Contact;
import com.gestioncontact.service.ContactService;

public class ContactFormController extends  SimpleFormController  {

	private ContactService contactService; 


	private static final String SUCCESS_VIEW="redirect:contactList.html";




	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
	throws Exception {

		Contact contact = (Contact)command;		
		String action=(String)request.getParameter("mode");
		if("edit".equals(action)){
			this.getContactService().modifier(contact);
		}else if("create".equals(action)){
			this.getContactService().creer(contact);	
		}

		return new ModelAndView(SUCCESS_VIEW);

	}


	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));		
		binder.registerCustomEditor(Long.class, new CustomNumberEditor(Long.class, true));		
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

}
