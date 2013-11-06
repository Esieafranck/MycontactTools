package com.gestioncontact.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.gestioncontact.modele.Contact;

public class AddContactController extends  AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		ModelAndView mav=new ModelAndView();
		
		Contact contact= (Contact) httpServletRequest.getSession().getAttribute("contact");
		if(contact==null){
			mav.addObject("contactForm",new Contact());
			mav.addObject("mode","create");
			
		}else{

			mav.addObject("mode", "edit");
			mav.addObject("contactForm",contact);			
		}
		return mav;
	}

}
