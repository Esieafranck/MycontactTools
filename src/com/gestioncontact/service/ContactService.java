package com.gestioncontact.service;

import java.util.Map;

import com.gestioncontact.modele.Contact;

public interface ContactService {
/**
 * 
 * @return
 */
 Map<Long,Contact> chercherTout();
 /**
  * 
  * @param id
  * @return
  */
 Contact chercherParId(long id);
 /**
  * 
  * @param contact
  */
 void creer(Contact contact);
 /**
  * 
  * @param contact
  * @return
  */
 Contact modifier(Contact contact);
 /**
  * 
  * @param contact
  */
 void supprimer(Contact contact);
 /**
  * 
  */
 void supprimerTout();
 /**
  * 
  * @param nom
  * @param prenom
  * @param email
  * @return
  */
Map<Long,Contact> chercherParNomPrenomMail(String nom,String prenom,String email);


}
