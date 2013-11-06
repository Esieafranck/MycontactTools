package com.gestioncontact.modele;

import java.io.Serializable;

public class Adresse implements Serializable{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6567610313618033144L;
	/**
	 * identifaint technique
	 */
	private long id;
	/**
	 * numero
	 */
	private String numero;
	/**
	 * rue
	 */
	private String rue;
	/**
	 * code postal
	 */
	private String codePostal;
	/**
	 * ville
	 */
	private String ville;
	/**
	 * {@link Contact}
	 */
	private Contact contact=new Contact();
	
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
	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	/**
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}
	/**
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}
	/**
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}
	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}
	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	/**
	 * @return the contact
	 */
	public Contact getContact() {
		return contact;
	}
	/**
	 * @param contact the contact to set
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}
}
