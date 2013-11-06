package com.gestioncontact.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.gestioncontact.exception.ContactException;
import com.gestioncontact.modele.Adresse;
import com.gestioncontact.modele.Contact;

public class AdresseServiceImpl implements AdresseService {

	private static long idAdresse;	
	private Map<Long,Adresse> adresses=new HashMap<Long, Adresse>();	

	@Override
	public Adresse chercherParId(long id) {
		return  adresses.get(id);
	}

	@Override
	public void creer(Adresse adresse,Contact contact) {
		adresse.setId(++idAdresse);	
		adresses.put(adresse.getId(), adresse);
		contact.addAdresse(adresse);
	}

	@Override
	public void chercherParContact(Contact contact) throws ContactException{

		if(contact!=null && contact.getId()!=0){
			Set<Entry<Long, Adresse>> entrySet=adresses.entrySet();	
			for (Entry<Long, Adresse> entry : entrySet) {
				Adresse adresse=entry.getValue();
				if(adresse.getContact().getId()==contact.getId()){
					contact.addAdresse( adresse);
				}
			}
		}else{
			throw new ContactException("Le contact n'existe pas dans la base de données");
		}
	}

	@Override
	public Contact modifier(Adresse adresse) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimer(Adresse adresse) {
		this.adresses.remove(adresse.getId());
		adresse.getContact().removeAdresse(adresse);
	}

	@Override
	public void supprimerAdresse(Set<Adresse> adresses) {
		for (Adresse adresse : adresses) {
			this.supprimer(adresse);
		}
	}

	@Override
	public void supprimerTout() {
		adresses.clear();
	}
}
