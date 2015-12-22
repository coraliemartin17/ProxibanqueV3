package fr.gtm.proxibanquesi.domaine;

import java.sql.Date;

/**
 * Classe abstraite repr�sentant un compte en banque g�n�rique.
 * @author Martin Coralie - De Bruyn Alexandre
 */
public abstract class Compte {

	// Propri�t�s
	/** Num�ro du compte */
	private int numCompte;
	private double solde;
	private Date dateOuverture;
	private int idcli;
	
	// Getters & Setters
	public int getNumCompte() {
		return numCompte;
	}
	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double d) {
		this.solde = d;
	}
	public Date getDateOuverture() {
		return dateOuverture;
	}
	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public int getIdcli() {
		return idcli;
	}
	public void setIdcli(int idcli) {
		this.idcli = idcli;
	}
	// Affichage
	@Override
	public String toString() {
		return "CompteBancaire [numCompte=" + numCompte + ", solde=" + solde
				+ "]";
	}

}