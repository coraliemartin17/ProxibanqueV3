package fr.gtm.proxibanquesi.domaine;

/**
 * Classe repr�sentant un compte �pargne, avec un taux de r�muneration d�clarer � 3%.
 * @author Martin Coralie - De Bruyn Alexandre
 */
public class CompteEpargne extends Compte {

	// Propri�t�s
	private double tauxRemuneration = 0.03;
	
	// Constructeurs
	public CompteEpargne() {
		super();
	}
	public CompteEpargne(double tauxRemuneration) {
		this();
		this.tauxRemuneration = tauxRemuneration;
	}

	// Getters & Setters
	public double getTauxRemuneration() {
		return tauxRemuneration;
	}
	public void setTauxRemuneration(double tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}
	
	// M�thodes
//	@Override
//	public void typeCompte(ICompteBancaire compte) {
//		CompteEpargne.class.getTypeName();
//	}
//	@Override
//	public void getProprietaire(Client client) {
//		// TODO Auto-generated method stub
//		
//	}

	// Affichage
	@Override
	public String toString() {
		return "CompteEpargne [numCompte=]" + getNumCompte() + ", solde=" + getSolde() + "]";
	}

}