package fr.gtm.proxibanquesi.domaine;

 /** Classe repr�sentant un placement boursier.
 * @author Martin Coralie - De Bruyn Alexandre
 */
public class Placement {

	// Propri�t�s
	
	/**  la bource o� est r�alis�e le placement*/
	private String bourse;
	/**  la somme plac�e*/
	private double somme;

	// Constructeur
	public Placement(String bourse, double somme) {
		super();
		this.bourse = bourse;
		this.somme = somme;
	}

	// Getters & Setters
	public String getBourse() {
		return bourse;
	}
	public void setBourse(String bourse) {
		this.bourse = bourse;
	}
	public double getSomme() {
		return somme;
	}
	public void setSomme(double somme) {
		this.somme = somme;
	}

	// Affichage
	@Override
	public String toString() {
		return "Placement [bourse=" + bourse + ", somme=" + somme + "]\n";
	}
}