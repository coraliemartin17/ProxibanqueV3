package fr.gtm.proxibanquesi.domaine;

/**
 * Classe repr�sentant un compte courant, avec autorisation de d�couvert d�clarer de 1000 euro.
 * @author Martin Coralie - De Bruyn Alexandre
 */
public class CompteCourant extends Compte {

	// Propri�t�s
	private double autorisationDecouvert = 1000;
	
	// Constructeurs
	public CompteCourant() {
		super();
	}
	public CompteCourant(double solde) {
		super();
		setSolde(solde);
	}
	

	// Getters & Setters
	public double getAutorisationDecouvert() {
		return autorisationDecouvert;
	}
	public void setAutorisationDecouvert(double d) {
		this.autorisationDecouvert = d;
	}

	// M�thodes
//	@Override
//	public void typeCompte(ICompteBancaire compte) {
//		CompteCourant.class.getTypeName();
//		
//	}
//	@Override
//	public void getProprietaire(Client client) {
//		// TODO Auto-generated method stub
//		
//	}
	
	// Affichage
	@Override
	public String toString() {
		return "CompteCourant [numcompte=" + this.getNumCompte() + ", autorisationDecouvert=" + autorisationDecouvert
				+ ", solde=" + getSolde() + "]";
	}

}