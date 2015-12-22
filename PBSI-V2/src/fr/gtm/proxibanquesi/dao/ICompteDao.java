package fr.gtm.proxibanquesi.dao;

import java.util.ArrayList;

import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.domaine.CompteCourant;
import fr.gtm.proxibanquesi.domaine.CompteEpargne;
import fr.gtm.proxibanquesi.domaine.Conseiller;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;

/**
 * Cette interface permet d'effectuer les fonctions de CRUD pour la table Compte
 * de la base de donn�es.
 * 
 * @author Alexandre De Bruyn
 *
 */
public interface ICompteDao {

	/**
	 * M�thode de cr�ation un compte Epargne.
	 * 
	 * @param comt
	 *            : le client
	 * @return
	 */
	public CompteEpargne createEpargne(CompteEpargne comt);

	/**
	 * M�thode de cr�ation un compte Courant.
	 * 
	 * @param comt
	 *            : le client
	 * @return
	 */
	public CompteCourant createCourant(CompteCourant comt);

	/**
	 * M�thode pour lire les informations d'un compte courant.
	 * 
	 * @param comt
	 *            : le compte
	 * @return
	 * @throws LigneInexistanteException
	 */
	public CompteCourant readCourant(CompteCourant comt) throws LigneInexistanteException;
	
	/**
	 * M�thode pour lire les informations d'un compte epargne.
	 * 
	 * @param comt
	 *            : le compte
	 * @return
	 * @throws LigneInexistanteException
	 */
	public CompteEpargne readEpargne(CompteEpargne comt) throws LigneInexistanteException;

	/**
	 * M�thode pour supprimer un compte.
	 * 
	 * @param comt
	 *            : le client
	 * @return
	 * @throws LigneInexistanteException
	 */
	public int delete(Compte comt) throws LigneInexistanteException;

	/**
	 * M�thode qui r�cup�re la liste des num�ros de compte courant d'un client � partir
	 * de son identifiant.
	 * 
	 * @param id
	 *            L'identifiant du client
	 * @return Une liste de num�ros de compte
	 */
	public ArrayList<Integer> getListeComptesCourant(int id);
	
	/**
	 * M�thode qui r�cup�re la liste des num�ros de compte �pargne d'un client � partir
	 * de son identifiant.
	 * 
	 * @param id
	 *            L'identifiant du client
	 * @return Une liste de num�ros de compte
	 */
	public ArrayList<Integer> getListeComptesEpargne(int id);
	
	/**
	 * M�thode de modification d'un compte Courant.
	 * @param compte : compte
	 * @return
	 * @throws LigneInexistanteException
	 */
	public int updateCourant(CompteCourant compte) throws LigneInexistanteException;
	
	/**
	 * M�thode de modification d'un compte Epargne.
	 * @param compte
	 * @return
	 * @throws LigneInexistanteException
	 */
	public int updateEpargne(CompteEpargne compte) throws LigneInexistanteException;
	
	/**
	 * M�thode pour d�terminer le type d'un compte soit Courant soit Epargne.
	 * @param id : l'identifiant du client
	 * @return
	 * @throws LigneInexistanteException
	 */
	public String typeCompte(int id) throws LigneInexistanteException;
	

	

}
