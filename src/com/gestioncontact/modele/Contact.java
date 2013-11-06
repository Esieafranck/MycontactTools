package com.gestioncontact.modele;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Contact implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7377350898812471380L;
	/**
	 * identfiant technique
	 */
	private long id;
	/**
	 * nom
	 */
	private String nom;
	/**
	 * prenom
	 */
	private String prenom;
	/**
	 * email
	 */
	private String email;
	/**
	 * date de naissance
	 */
	private Date dateNaissance;
	/**
	 * actif
	 */
	private boolean actif;
	/**
	 * liste d {@link Adresse}
	 */
	private Set<Adresse> adresses=new HashSet<Adresse>();
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	public void addAdresse(Adresse adresse){
		adresse.setContact(this);
		this.getAdresses().add(adresse);
	}
	public void removeAdresse(Adresse adresse){

		this.getAdresses().remove(adresse);
	}


	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the dateNaissance
	 */
	public Date getDateNaissance() {
		return dateNaissance;
	}
	/**
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	/**
	 * @return the actif
	 */
	public boolean isActif() {
		return actif;
	}
	/**
	 * @param actif the actif to set
	 */
	public void setActif(boolean actif) {
		this.actif = actif;
	}
	/**
	 * @return the adresses
	 */
	public Set<Adresse> getAdresses() {
		return adresses;
	}
	/**
	 * @param adresses the adresses to set
	 */
	public void setAdresses(Set<Adresse> adresses) {
		this.adresses = adresses;
	}
}
