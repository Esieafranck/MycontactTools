package com.gestioncontact.service;

import java.util.Set;

import com.gestioncontact.exception.ContactException;
import com.gestioncontact.modele.Adresse;
import com.gestioncontact.modele.Contact;

public interface AdresseService {

	/**
	 * 
	 * @param id
	 * @return
	 */
	Adresse chercherParId(long id);
	/**
	 * 
	 * @param adresse
	 * @param contact
	 */
	void creer(Adresse adresse,Contact contact);
	/**
	 * 
	 * @param adresse
	 * @return
	 */
	Contact modifier(Adresse adresse);
	/**
	 * 
	 * @param adresse
	 */
	void supprimer(Adresse adresse);
	/**
	 * 
	 * @param contact
	 * @throws ContactException
	 */
	void chercherParContact(Contact contact)
	throws ContactException;
	/**
	 * 
	 * @param adresses
	 */
	void supprimerAdresse(Set<Adresse> adresses);
	/**
	 * 
	 */
	void supprimerTout();

}
