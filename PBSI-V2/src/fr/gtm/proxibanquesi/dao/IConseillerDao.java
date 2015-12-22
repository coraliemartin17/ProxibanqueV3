package fr.gtm.proxibanquesi.dao;

import fr.gtm.proxibanquesi.domaine.Conseiller;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;

/**
 * Cette interface permet d'effectuer les fonctions de CRUD
 * pour la table CONSEILLER de la base de donn�es.
 * @author Alexandre De Bruyn
 *
 */

public interface IConseillerDao {
	
	/**
	 * M�thode de cr�ation un conseiller.
	 * @param cons qui est le conseiller.
	 * @return
	 * @throws LigneExistanteException
	 */
	public int create(Conseiller cons) throws LigneExistanteException;
	
	/**
	 * M�thode pour lire les informations d'un conseiller.
	 * @param cons qui est le conseiller.
	 * @return
	 * @throws LigneInexistanteException
	 */
	public Conseiller read(Conseiller cons) throws LigneInexistanteException;
	
	/**
	 * M�thode pour modifier les informations d'un conseiller.
	 * @param cons qui est le conseiller.
	 * @return
	 * @throws LigneInexistanteException
	 */
	public int update(Conseiller cons) throws LigneInexistanteException;
	
	/**
	 * M�thode pour supprimer un conseiller.
	 * @param cons qui est le conseiller.
	 * @return
	 * @throws LigneInexistanteException
	 */
	public int delete(Conseiller cons) throws LigneInexistanteException;
	
	/**
	 * M�thode pour lire les informations d'un conseiller � partir de son identifiant.
	 * @param cons qui est le conseiller.
	 * @return
	 * @throws LigneInexistanteException
	 */
	public Conseiller getID(Conseiller cons) throws LigneInexistanteException;
	
	/**
	 * M�thode pour v�rifier le login et le password du conseiller
	 * @param userTemp
	 * @return
	 * @throws LigneInexistanteException
	 */
	public Conseiller getUser(Conseiller userTemp) throws LigneInexistanteException;


	
}
