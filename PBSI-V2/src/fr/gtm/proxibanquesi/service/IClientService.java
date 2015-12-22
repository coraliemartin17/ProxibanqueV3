package fr.gtm.proxibanquesi.service;

import java.util.ArrayList;

import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.domaine.CompteCourant;
import fr.gtm.proxibanquesi.domaine.CompteEpargne;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;
import fr.gtm.proxibanquesi.exceptions.SoldeInsuffisantException;

/**
 * Interface de la couche Service du Client
 * Elle liste les m�thodes de CRUD d'un client, et les m�thodes pour lister ses diff�rents types de comptes.
 * @author Alexandre et Coralie
 *
 */
public interface IClientService {
	/**
	 * M�thode de cr�ation d'un client.
	 * @param cli : le client
	 * @return
	 * @throws LigneExistanteException
	 * @throws LigneInexistanteException
	 */
	public Client createClient(Client cli) throws LigneExistanteException, LigneInexistanteException;
	
	/**
	 * M�thode pour lire les informations d'un client.
	 * @param cli : le client
	 * @return
	 * @throws LigneInexistanteException
	 */
	public Client consulterClient(Client cli) throws LigneInexistanteException;
	
	/**
	 * M�thode pour modifier les informations d'un client.
	 * @param cli : le client
	 * @return
	 * @throws LigneInexistanteException
	 */
	public int modifierClient(Client cli) throws LigneInexistanteException;
	
	/**
	 * M�thode pour supprimer un client et ses comptes.
	 * @param cli : le client
	 * @return
	 * @throws LigneInexistanteException
	 */
	public int supprimerClient(Client cli) throws LigneInexistanteException;
	
	/**
	 * M�thode pour lister les comptes courants d'un client.
	 * @param cli : le client
	 * @return
	 */
	public Client getListeComptesCourant(Client cli);
	
	/**
	 * M�thode pour lister les comptes �pargnes d'un client.
	 * @param cli : le client
	 * @return
	 */
	public Client getListeComptesEpargne(Client cli);
	
	public ArrayList<CompteCourant> getComptesCourant(Client cli) throws LigneInexistanteException;
	
	public ArrayList<CompteEpargne> getComptesEpargne(Client cli) throws LigneInexistanteException;
	

}
