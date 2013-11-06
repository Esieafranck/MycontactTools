package com.gestioncontact.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.gestioncontact.modele.Contact;

public class ContactServiceImpl implements ContactService{
	private static long idContact;	
	private Map<Long,Contact> contacts=new HashMap<Long, Contact>();	

	@Override
	public Map<Long,Contact> chercherTout(){
		return this.contacts;
	}
	@Override
	public Map<Long,Contact> chercherParNomPrenomMail(String nom,String prenom,String email){
		Map<Long,Contact> contactsResult=new HashMap<Long, Contact>(); 
		Set<Entry<Long, Contact>> entrySet=this.contacts.entrySet();

		for (Entry<Long, Contact> entry : entrySet) {		
			Contact contact=entry.getValue();
			Long cle=entry.getKey();
			boolean toAdd=false;
			if(!"".equals(nom))
				if(contact.getNom().equals(nom)){
					toAdd=true;		 
				}else{
					continue;
				}
			if(!"".equals(prenom))
				if(contact.getPrenom().equals(prenom)){
					toAdd=true;		 
				}else{
					continue;
				}
			if(!"".equals(email))
				if(contact.getEmail().equals(email)){
					toAdd=true;		 
				}else{
					continue;
				}
			if(toAdd){
				contactsResult.put(cle, contact);
			}
		}
		return contactsResult;
	}

	@Override
	public Contact chercherParId(long id){
		return contacts.get(id);	
	}

	@Override		
	public void creer(Contact contact){
		contact.setId(++idContact);	
		contacts.put(contact.getId(), contact);
	}

	@Override
	public Contact modifier(Contact contact){
		long id=contact.getId();
		Contact contactBase=contacts.get(id);
		contact.setAdresses(contact.getAdresses());
		contactBase.setEmail(contact.getEmail());
		return contactBase;
	}

	@Override
	public void supprimer(Contact contact){
		contacts.remove(contact.getId());
	}

	@Override
	public void supprimerTout(){
		contacts.clear();
	}

}
